package com.cskaoyan.controller;


import com.cskaoyan.service.userManegeService.CollectServiceImpl;
import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CollectController {

    @Autowired
    CollectServiceImpl collectService;




    @RequestMapping("admin/collect/list")
    @ResponseBody
    public ResponseVO<Map> queryCollect(Integer userId, Integer valueId){
        ResponseVO<Map> userResponseVO = new ResponseVO<>();
        List<Collect> collects = collectService.queryCollect();
        if (userId != null && valueId != null){
            collects = collectService.queryCollectByUserIdAndValueID(userId,valueId);
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("items",collects);
        objectObjectHashMap.put("total",collects.size());
        userResponseVO.setData(objectObjectHashMap);
        userResponseVO.setErrno(0);
        userResponseVO.setErrmsg("成功");
        return userResponseVO;
    }
}
