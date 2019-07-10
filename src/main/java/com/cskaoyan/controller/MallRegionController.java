package com.cskaoyan.controller;


import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.service.MallRegionService;
import com.cskaoyan.bean.Region;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.MallRegionService;
import com.cskaoyan.bean.Province;
import com.cskaoyan.service.SystemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
@Api(tags = "商场地域",description = "MallRegionController是商场管理地域模块的Controller")
public class MallRegionController {
    @Autowired
    MallRegionService mallRegionService;
    @Autowired
    SystemService systemService;
    @RequestMapping("region/list")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")
    @ApiOperation(value = "showArea",notes = "地域展示功能")
    public ResponseVO<List<Province>> showArea(){

        List<Province> provinces = mallRegionService.showArea();
        ResponseVO<List<Province>> responseVO = new ResponseVO<>();
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"显示对象",name1);
        responseVO.setData(provinces);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
