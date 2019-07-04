package com.cskaoyan.controller;

import com.cskaoyan.Service.MallBrandService;
import com.cskaoyan.bean.Brand;
import com.cskaoyan.bean.Region;
import com.cskaoyan.mapper.mallManege.MallBrandMapper;
import com.cskaoyan.responseVo.ResponseVO1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class MallBrandController {
    @Autowired
    MallBrandService mallBrandService;


    @RequestMapping("brand/list")
    @ResponseBody
    public ResponseVO1<Map<String,Object>> showBrandList(String id,String name){
        ResponseVO1<Map<String,Object>> responseVO1 = new ResponseVO1<>();
        Map<String, Object> map = new HashMap<>();
        if(id==null&&name==null){
        List<Brand> brands = mallBrandService.showBrand();
            map.put("items",brands);
            map.put("total",map.size());

        }else{
            List<Brand> brands = mallBrandService.searchBrandByIdAndName(id, name);
            map.put("items",brands);
            map.put("total",map.size());
        }
        responseVO1.setData(map);
        responseVO1.setErrmsg("成功");
        responseVO1.setErrno(0);
        return responseVO1;
    }


    @RequestMapping("brand/delete")
    @ResponseBody
    public ResponseVO1<Object> deleteBrand(Brand brand){
        int i = mallBrandService.deleteBrand(brand);
        ResponseVO1<Object> responseVO1 = new ResponseVO1<>();
        responseVO1.setData(null);
        responseVO1.setErrmsg("成功");
        responseVO1.setErrno(0);
        return responseVO1;
    }


}
