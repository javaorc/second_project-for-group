package com.cskaoyan.controller;


import com.cskaoyan.service.userManegeService.CollectServiceImpl;
import com.cskaoyan.bean.Collect;
import com.github.pagehelper.PageHelper;
import com.cskaoyan.bean.vo.ResponseVO;
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
public class CollectController {

    @Autowired
    CollectServiceImpl collectService;




    @RequestMapping("admin/collect/list")
    @ResponseBody
    public ResponseVO<Map> queryCollect(int page, int limit,Integer userId, Integer valueId){
        ResponseVO<Map> userResponseVO = new ResponseVO<>();
        PageHelper.startPage(page,limit);

        List<Collect> collects = new ArrayList<Collect>();
        
        
        if (userId!=null&&valueId==null){
            collects = collectService.queryCollectByUserId(userId);
        }else if (userId == null&&valueId==null){
            collects = collectService.queryCollect();
        }else if (userId !=null&&valueId!=null){
            collects = collectService.queryCollectByUserIdAndValueID(userId,valueId);
        }else {
            collects=collectService.queryCollectByValueID(valueId);
        }
        
/*        List<Collect> collects = collectService.queryCollect();
        if (userId != null && valueId != null){
            collects = collectService.queryCollectByUserIdAndValueID(userId,valueId);
        }*/
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        PageInfo<Collect> collectPageInfo = new PageInfo<>(collects);
        objectObjectHashMap.put("items",collects);
        objectObjectHashMap.put("total",collectPageInfo.getTotal());
        userResponseVO.setData(objectObjectHashMap);
        userResponseVO.setErrno(0);
        userResponseVO.setErrmsg("成功");
        return userResponseVO;
    }
}
