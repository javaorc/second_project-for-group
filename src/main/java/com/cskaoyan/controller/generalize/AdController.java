package com.cskaoyan.controller.generalize;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.oss.MyOssClient;
import com.cskaoyan.service.SystemService;
import com.cskaoyan.service.generalize.AdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/3 16:50
 **/
@RestController
@RequestMapping("admin")
@Api(tags = "广告管理",description = "AdController是推广管理模块中广告管理的Controller")
public class AdController {

    @Autowired
    AdService adService;
    @Autowired
    SystemService systemService;

    @Autowired
    MyOssClient myOssClient;

    ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();

    @RequestMapping("ad/list")
    @ApiOperation(value = "findAdList",notes = "广告管理的展示以及查找功能")
    @RequiresPermissions(value = "admin:ad:list")
    public ResponseVO<Map<String, Object>> findAdList(int page, int limit, String name,
                                                      String content, String sort, String order) {
        return adService.findAdList(name,content,page,limit);
    }

    @RequestMapping("ad/update")
    @ApiOperation(value = "updateAd",notes = "广告管理的修改功能")
    @RequiresPermissions(value = "admin:ad:update")
    public ResponseVO<Ad> updateAd(@RequestBody Ad ad) {
        ResponseVO<Ad> adResponseVO = new ResponseVO<>();
        adResponseVO.setErrno(0);
        adResponseVO.setErrmsg("成功");
        int i = adService.updateAd(ad);
        if (i == 1) {
            adResponseVO.setData(ad);
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"update广告",name);
            return adResponseVO;
        }
        return null;
    }

    @RequestMapping("ad/delete")
    @ApiOperation(value = "deleteAd",notes = "广告管理的删除功能")
    @RequiresPermissions(value = "admin:ad:delete")
    public ResponseVO<Object> deleteAd(@RequestBody Ad ad) {
        ResponseVO<Object> adResponseVO = new ResponseVO<>();
        adResponseVO.setErrno(0);
        adResponseVO.setErrmsg("成功");
        int i = adService.deleteAd(ad);
        if (i == 1) {
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"delete广告",name);
            return adResponseVO;
        }
        return null;
    }

    /*添加*/
    @RequestMapping("storage/create")
    @ApiOperation(value = "uploadfile",notes = "文件上传")
    @RequiresPermissions(value = "admin:storage:create")
    public ResponseVO<Storage> file(MultipartFile file) throws IOException {
        ResponseVO<Storage> storageResponseVO = new ResponseVO<>();
        storageResponseVO.setErrno(0);
        storageResponseVO.setErrmsg("成功");
        String url = myOssClient.ossFileUpload(file);
        //设置返回参数的值
        Storage storage = new Storage();
        Date date = new Date();
        storage.setName(file.getOriginalFilename());
        storage.setAddTime(date);
        storage.setUpdateTime(date);

        String[] split = url.split("/");
        String key = split[split.length-1] + ".png";
        storage.setKey(key);

        storage.setSize((int) file.getSize());
        storage.setUrl(url);
        storage.setType(file.getContentType());
        storage.setDeleted(false);
        //将数据插入数据库
        int i = adService.insertStorage(storage);
        if (i == 1) {
            //通过key 查找出id ，将id赋值给storage
            int id = adService.queryStorageIdByKey(key);
            storage.setId(id);
            storageResponseVO.setData(storage);
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"上传图片",name);
            return storageResponseVO;
        }
        return null;
    }


    @RequestMapping("ad/create")
    @ApiOperation(value = "insertAd",notes = "添加广告功能")
    @RequiresPermissions(value = "admin:ad:create")
    public ResponseVO<Ad> insertAd(@RequestBody Ad ad) {
        ResponseVO<Ad> adResponseVO = new ResponseVO<>();
        adResponseVO.setErrno(0);
        adResponseVO.setErrmsg("成功");
        Date date = new Date();
        ad.setAddTime(date);
        ad.setUpdateTime(date);
        ad.setDeleted(false);
        int i = adService.insertAd(ad);
        if (i == 1) {
            adResponseVO.setData(ad);
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"insert广告",name);
            return adResponseVO;
        }
        return null;
    }
}
