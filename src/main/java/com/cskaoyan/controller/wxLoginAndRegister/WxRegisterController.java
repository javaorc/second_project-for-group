package com.cskaoyan.controller.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxLoginAndRegister.WxRegisterService;
import com.cskaoyan.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class WxRegisterController {
    @Autowired(required = false)
    WxRegisterService wxRegisterService;
    @RequestMapping("wx/auth/register")
    @ResponseBody
    public ResponseVO  register(@RequestBody User user, HttpServletRequest request){
        user.setUpdateTime(new Date());
        user.setAddTime(new Date());
        user.setLastLoginIp(request.getLocalAddr());
        if(user.getNickname()==null){
            user.setNickname(user.getUsername());
        }
        if(!wxRegisterService.userExist(user)){
            user.setPassword(Md5Util.getMD5(user.getPassword()));
            int create = wxRegisterService.createUser(user);
            if(create>0){
            ResponseVO<Object> responseVO = new ResponseVO<>();
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return  responseVO;
            }
           return null;
        }
        return null;
    }
}
