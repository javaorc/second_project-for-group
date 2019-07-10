package com.cskaoyan.controller;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Kind;
import com.cskaoyan.bean.Province;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.mallManege.MallCategoryMapper;
import com.cskaoyan.service.SystemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("admin")
@Api(tags = "产品品牌",description = "MallCategoryController是商场中的商品品牌模块的Controller")
public class MallCategoryController {
    @Autowired(required = false)
    MallCategoryMapper mallCategoryMapper;
    @Autowired
    SystemService systemService;

    @RequestMapping("category/list")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")
    @ApiOperation(value = "showAllCategory",notes = "展示商品品牌功能")
    public ResponseVO<List<Kind>> showAllCategory(){

        List<Kind> kinds = mallCategoryMapper.showAllCategory();

        ResponseVO<List<Kind>> responseVO = new ResponseVO<>();
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"显示对象",name1);
        responseVO.setData(kinds);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }


    @RequestMapping("category/l1")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")
    @ApiOperation(value = "showKindCategory",notes = "展示查询的商品品牌功能")
    public ResponseVO<List<Map>> showKindCategory(){

        List<Kind> kinds = mallCategoryMapper.showKindCategory();
        List<Map> mapList=new ArrayList<>();
        for(Kind kind:kinds){
            Map<String,Object> map=new HashMap<>();
            map.put("value",kind.getId());
            map.put("label",kind.getName());
            mapList.add(map);
        }
        ResponseVO<List<Map>> responseVO = new ResponseVO<>();
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"显示一级对象",name1);
        responseVO.setData(mapList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }


    @RequestMapping("category/delete")
    @ResponseBody
    @ApiOperation(value = "deleteKindCategory",notes = "删除部分商品品牌功能")
    public ResponseVO<Object> deleteKindCategory(@RequestBody Category category){
        int i = mallCategoryMapper.deleteCategory(category);
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"删除对象",name1);
        if(i>0) {
            ResponseVO<Object> responseVO = new ResponseVO<>();
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }

        return null;
    }

    @RequestMapping("category/create")
    @ResponseBody
    @ApiOperation(value = "createCategory",notes = "创建商品品牌功能")
    public ResponseVO<Object> createCategory(@RequestBody Category category){
        Date date = new Date(System.currentTimeMillis());
        category.setAddTime(date);
        category.setUpdateTime(date);
        int i = mallCategoryMapper.createCategory(category);
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"创建对象",name1);
        if(i>0) {

            ResponseVO<Object> responseVO = new ResponseVO<>();
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }



    @RequestMapping("category/update")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:update")
    @ApiOperation(value = "updateCategory",notes = "修改商品品牌功能")
    public ResponseVO<Object> updateCategory(@RequestBody Category category){
        Date date = new Date(System.currentTimeMillis());
        category.setUpdateTime(date);
        int i = mallCategoryMapper.updateCategory(category);
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"更新对象",name1);
        if(i>0) {
            ResponseVO<Object> responseVO = new ResponseVO<>();
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }

}
