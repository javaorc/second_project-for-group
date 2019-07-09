package com.cskaoyan.controller;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Province;


import com.cskaoyan.service.MallBrandService;
import com.cskaoyan.bean.Brand;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.MallBrandService;
import com.cskaoyan.bean.Brand;
import com.cskaoyan.service.SystemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class MallBrandController {
    @Autowired
    MallBrandService mallBrandService;
    @Autowired
    SystemService systemService;


    @RequestMapping("brand/list")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")
    public ResponseVO<Map<String,Object>> showBrandList(Integer page,Integer limit,String id, String name){
        PageHelper.startPage(page,limit);
        ResponseVO<Map<String,Object>> responseVO = new ResponseVO<>();
        Map<String, Object> map = new HashMap<>();
        if(id==null&&name==null){
        List<Brand> brands = mallBrandService.showBrand();
            PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
            map.put("items",brands);
            map.put("total",brandPageInfo.getTotal());

        }else{
            List<Brand> brands = mallBrandService.searchBrandByIdAndName(id, name);
            PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
            map.put("items",brands);
            map.put("total",brandPageInfo.getTotal());
        }
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"显示列表",name1);
        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }


    @RequestMapping("brand/delete")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:delete")
    public ResponseVO<Object> deleteBrand(Brand brand){
        int i = mallBrandService.deleteBrand(brand);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"品牌删除",name1);
        responseVO.setData(null);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }


    @RequestMapping("brand/update")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:update")
    public ResponseVO<Object> updateBrand(@RequestBody Brand brand){
        Date date = new Date(System.currentTimeMillis());
        brand.setUpdateTime(date);
        int i = mallBrandService.updateBrandByBid(brand);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"更新对象",name1);
        responseVO.setData(brand);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping("brand/create")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:insert")
    public ResponseVO<Object> createBrand(@RequestBody Brand brand){
        Date date = new Date(System.currentTimeMillis());
        brand.setAddTime(date);
        brand.setUpdateTime(date);
        int i = mallBrandService.insertBrand(brand);
        if(i>0){
        ResponseVO<Object> responseVO = new ResponseVO<>();
            String name1 = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"插入对象",name1);
        responseVO.setData(brand);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
        }
        return null;
    }


}
