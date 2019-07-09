package com.cskaoyan.controller.wxLoginAndRegister;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.wxLoginAndRegister.WxLoginMapper;
import com.cskaoyan.tokenManager.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class WxLoginController {
    @Autowired(required = false)
    WxLoginMapper wxLoginMapper;
    @RequestMapping("wx/auth/login")
    @ResponseBody
    public ResponseVO<Map<Object,Object>> login(@RequestBody User user1, HttpServletRequest request) {
        user1.setLastLoginTime(new Date());
        User user = wxLoginMapper.isUser(user1);
        String NickName=user.getNickname();
            if(NickName==null){
                NickName=user.getUsername();
            }
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(NickName);
        userInfo.setAvatarUrl(user.getAvatar());
        UserToken userToken = UserTokenManager.generateToken(user.getId());
        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", userToken.getToken());
        result.put("tokenExpire", userToken.getExpireTime().toString());
        result.put("userInfo", userInfo);
        ResponseVO<Map<Object,Object>> responseVO = new ResponseVO<>();
        responseVO.setData(result);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping("wx/user/index")
    @ResponseBody
    public ResponseVO<Map<Object,Object>> showIndex(HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return null;
        }
        List<Order> orders = wxLoginMapper.queryOrderByUid(userId);
        Map<Object, Object> data = new HashMap<Object, Object>();
        //***********************************
        //根据userId查询订单信息
        OrderType orderType = new OrderType(0,0,0,0);
        for(Order order:orders){
            if(order.getOrderStatus()==101){
            orderType.setUnpaid((orderType.getUnpaid()+1));
        } else if(order.getOrderStatus()==201){
            orderType.setUnship(orderType.getUnship()+1);
        } else if(order.getOrderStatus()==301){
            orderType.setUnrecv(orderType.getUnrecv()+1);
        }
            if(order.getComments()==null){
                orderType.setUncomment(orderType.getUncomment()+1);
            }
        }
        data.put("order",orderType);
        ResponseVO<Map<Object,Object>> responseVO = new ResponseVO<>();
        responseVO.setData(data);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

}
