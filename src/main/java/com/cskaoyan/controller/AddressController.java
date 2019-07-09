package com.cskaoyan.controller;



import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.userManegeService.AddressServiceImpl;
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
public class AddressController {

    @Autowired
    AddressServiceImpl addressService;

    @RequestMapping("admin/address/list")
    @ResponseBody
    public ResponseVO<Map> queryAddress(int page, int limit, Integer userId, String name){
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        List<Address> addresses;
        if (userId==null&&name==null){
            addresses = addressService.queryAddress();
        }else if (userId!=null&&name==null){
            addresses = addressService.queryAddressByUserId(userId);
        }else if (userId==null&&name!=null){
            addresses = addressService.queryAddressByName(name);
        }else {
            addresses = addressService.queryAddressByUserIdAndName(userId,name);
        }
        PageHelper.startPage(page,limit);
        HashMap<Object, Object> map = new HashMap<>();
        PageInfo<Address> addressPageInfo = new PageInfo<>();
        map.put("items",addresses);
        map.put("total",addressPageInfo.getTotal());
        mapResponseVO.setData(map);
        mapResponseVO.setErrno(0);
        mapResponseVO.setErrmsg("成功");
        return mapResponseVO;
    }
}
