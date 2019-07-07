package com.cskaoyan.controller;


import com.cskaoyan.service.userManegeService.UserServiceImpl;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.vo.ResponseVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

/*    @RequestMapping("admin/user/list")
    @ResponseBody
    public ResponseVO<Map> queryUser(int page, int limit, String username, String mobile){
        ResponseVO<Map> userResponseVO = new ResponseVO<>();
        PageHelper.startPage(page,limit);
        List<User> users = userService.queryUser();
        if (username != null && mobile != null){
            users = userService.queryUserByUsernameAndMobile(username,mobile);
        }
        HashMap<Object, Object> map = new HashMap<>();

        PageInfo<User> userPageInfo= new PageInfo<>(users);

        map.put("items",users);
        map.put("total",userPageInfo.getTotal());
        userResponseVO.setData(map);
        userResponseVO.setErrno(0);
        userResponseVO.setErrmsg("成功");
        return userResponseVO;
    }*/
    @RequestMapping("admin/user/list")
    @ResponseBody
    public ResponseVO<Map> queryUser(int page, int limit, String username, String mobile){
        ResponseVO<Map> userResponseVO = new ResponseVO<>();
        PageHelper.startPage(page,limit);
        List<User> users = new ArrayList<>();
        if (username!=null&&mobile==null){
            users = userService.queryUserByUsername(username);
        }else if (username == null&&mobile==null){
            users = userService.queryUser();
        }else if (username !=null&&mobile!=null){
            users = userService.queryUserByUsernameAndMobile(username,mobile);
        }else {
            users=userService.queryUserByMoblie(mobile);
        }
        HashMap<Object, Object> map = new HashMap<>();

        PageInfo<User> userPageInfo= new PageInfo<>(users);

        map.put("items",users);
        map.put("total",userPageInfo.getTotal());
        userResponseVO.setData(map);
        userResponseVO.setErrno(0);
        userResponseVO.setErrmsg("成功");
        return userResponseVO;
    }



}
