package com.cskaoyan.controller;

import com.cskaoyan.bean.vo.ResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("auth/login")
    @ResponseBody
    public ResponseVO<String> login(@RequestBody Map map) {
        String username=(String)map.get("username");
        String password=(String)map.get("password");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            ResponseVO<String> responseVO = new ResponseVO<>();
            responseVO.setData((String) subject.getSession().getId());
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }catch (Exception e)
        {
            return null;
        }

    }

    @RequestMapping("auth/info")
    @ResponseBody
    public ResponseVO<Map> info(String token) {
        ResponseVO<Map> responseVO = new ResponseVO<>();

        responseVO.setErrno(0);
        responseVO.setErrmsg("成功");

        Map<String, Object> map = new HashMap<>();
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","admin123");
        map.put("perms",new String[]{"*"});
        map.put("roles",new String[]{"超级管理员"});

        responseVO.setData(map);

        return responseVO;
    }
}
