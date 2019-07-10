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
public class MallCategoryController {
    @Autowired(required = false)
    MallCategoryMapper mallCategoryMapper;
    @Autowired
    SystemService systemService;

    @RequestMapping("category/list")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")
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
    @RequiresPermissions(value = "admin:storage:delete")
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
    @RequiresPermissions(value = "admin:storage:insert")
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
