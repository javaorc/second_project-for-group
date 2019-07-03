package com.cskaoyan.controller;

import com.cskaoyan.bean.vo.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("auth/login")
    @ResponseBody
    public ResponseVO<String> login(String username, String password) {
        ResponseVO<String> responseVO = new ResponseVO<>();
        responseVO.setData("69b2bd47-42d3-440f-99f6-17dea371c0e9");
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
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
