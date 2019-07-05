package com.cskaoyan.controller;


import com.cskaoyan.service.userManegeService.UserServiceImpl;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.vo.ResponseVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("admin/user/list")
    @ResponseBody
    public ResponseVO<Map> queryUser(int page, int limit, String username, String mobile){
        ResponseVO<Map> userResponseVO = new ResponseVO<>();
        PageHelper.startPage(page,limit);
        List<User> users = userService.queryUser();
        if (username != null && mobile != null){
            users = userService.queryUserByUsernameAndMobile(username,mobile);
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("items",users);
        objectObjectHashMap.put("total",users.size());
        userResponseVO.setData(objectObjectHashMap);
        userResponseVO.setErrno(0);
        userResponseVO.setErrmsg("成功");
        return userResponseVO;
    }



}
