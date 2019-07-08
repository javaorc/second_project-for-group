package com.cskaoyan.controller.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserInfo;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.wxLoginAndRegister.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Controller
public class Login {
    @Autowired(required = false)
    LoginMapper loginMapper;
    @RequestMapping("wx/auth/login")
    @ResponseBody
    public ResponseVO<Map> login(@RequestBody User user1) {
        user1.setLastLoginTime(new Date());
        User user = loginMapper.isUser(user1);
        if(user!=null) {
            ResponseVO<Map> mapResponseVO = new ResponseVO<>();
            Map<String, Object> map = new HashMap<>();
            map.put("token", "xydfxxq4t13gnbkicph29uq18ac1q050");
            map.put("tokenExpire", "2019-07-09T01:09:36.795");
            UserInfo admin123 = new UserInfo(user.getAvatar(),user.getNickname());
            map.put("userInfo", admin123);
            mapResponseVO.setData(map);
            mapResponseVO.setErrmsg("成功");
            mapResponseVO.setErrno(0);
            return mapResponseVO;
        }
            return null;
    }


}
