package com.cskaoyan.controller;


import com.cskaoyan.bean.Footprint;
import com.cskaoyan.bean.History;
import com.cskaoyan.service.userManegeService.FootprintServiceImpl;
import com.cskaoyan.service.userManegeService.HistoryServiceImpl;
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
    @Autowired
    HistoryServiceImpl historyService;
    @Autowired
    FootprintServiceImpl footprintService;

    @RequestMapping("admin/user/list")
    @ResponseBody
    public ResponseVO<Map> queryUser(int page, int limit, String username, String mobile){
        ResponseVO<Map> userResponseVO = new ResponseVO<>();
        PageHelper.startPage(page,limit);
        List<User> users;
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

    @RequestMapping("admin/history/list")
    @ResponseBody
    public ResponseVO<Map> queryHistory(Integer page,Integer limit){
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        PageHelper.startPage(page,limit);
        List<History> histories = historyService.queryHistory();
        PageInfo<History> historyPageInfo = new PageInfo<>(histories);
        Map<Object, Object> map = new HashMap<>();
        map.put("items",histories);
        map.put("total",historyPageInfo.getTotal());
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }



    @RequestMapping("admin/footprint/list")
    @ResponseBody
    public ResponseVO<Map> queryFootprint(Integer page,Integer limit){
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        List<Footprint> footprints = footprintService.queryFootprint();
        PageHelper.startPage(page,limit);
        PageInfo<Footprint> footprintPageInfo = new PageInfo<>(footprints);
        Map<Object, Object> map = new HashMap<>();
        map.put("items",footprints);
        map.put("total",footprintPageInfo.getTotal());
        mapResponseVO.setErrno(0);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setData(map);


        return mapResponseVO;
    }



}
