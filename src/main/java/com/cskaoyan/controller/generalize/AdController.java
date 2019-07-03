package com.cskaoyan.controller.generalize;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.ResponseVO;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.service.generalize.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/3 16:50
 **/
@Controller
@RequestMapping("admin")
public class AdController {

    @Autowired
    AdService adService;

    @RequestMapping("ad/list")
    @ResponseBody
    public ResponseVO<Map<String, Object>> findAdList(int page, int limit, String name, String content, String sort, String order) {
        ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        List<Ad>  adList = adService.findAdList(name,content);
        int total = adList.size();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("items", adList);
        mapResponseVO.setData(map);
        return mapResponseVO;
    }

    @RequestMapping("ad/update")
    @ResponseBody
    public ResponseVO<Ad> updateAd(@RequestBody Ad ad) {
        ResponseVO<Ad> adResponseVO = new ResponseVO<>();
        adResponseVO.setErrno(0);
        adResponseVO.setErrmsg("成功");
        int i = adService.updateAd(ad);
        if (i == 1) {
            adResponseVO.setData(ad);
            return adResponseVO;
        }
        return null;
    }

    @RequestMapping("ad/delete")
    @ResponseBody
    public ResponseVO<Object> deleteAd(@RequestBody Ad ad) {
        ResponseVO<Object> adResponseVO = new ResponseVO<>();
        adResponseVO.setErrno(0);
        adResponseVO.setErrmsg("成功");
        int i = adService.deleteAd(ad);
        if (i == 1) {
            return adResponseVO;
        }
        return null;
    }

    /*添加*/
    @RequestMapping("storage/create")
    @ResponseBody
    public ResponseVO<Storage> file(MultipartFile file) throws IOException {
        ResponseVO<Storage> storageResponseVO = new ResponseVO<>();
        storageResponseVO.setErrno(0);
        storageResponseVO.setErrmsg("成功");

        //String path = getClass().getResource("/").getPath();
        //文件上传相关
        File dir = new File("E://fileupload");
        if (!dir.exists()) {
            dir.mkdir();
        }
        String fileName = file.getOriginalFilename();
        File file1 = new File(dir, fileName);
        file.transferTo(file1);
        //设置返回参数的值
        Storage storage = new Storage();
        Date date = new Date();
        storage.setName(file.getOriginalFilename());
        storage.setAddTime(date);
        storage.setUpdateTime(date);
        String key = UUID.randomUUID() + ".png";
        storage.setKey(key);
        storage.setSize((int) file1.length());
        storage.setUrl(file1.getAbsolutePath());
        storage.setType("image/png");
        storage.setDeleted(false);
        //将数据插入数据库
        int i = adService.insertStorage(storage);
        if (i == 1) {
            //通过key 查找出id ，将id赋值给storage
            int id = adService.queryStorageIdByKey(key);
            storage.setId(id);
            storageResponseVO.setData(storage);
            return storageResponseVO;
        }
        return null;
    }


    @RequestMapping("ad/create")
    @ResponseBody
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
            return adResponseVO;
        }
        return null;
    }
}
