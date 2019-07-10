package com.cskaoyan.controller.wxCollectZLX;


import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxGoods4;
import com.cskaoyan.service.wxCollectZLX.WxCollectZLXServiceImpl;
import com.cskaoyan.service.wxGoods.WxGoodsServiceImpl;
import com.cskaoyan.tokenManager.UserTokenManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class WxCollectControllerZLX {

    @Autowired
    WxCollectZLXServiceImpl collectZLXService;

    @Autowired
    WxGoodsServiceImpl goodsService;


    @RequestMapping("wx/collect/list")
    @ResponseBody
    public ResponseVO<Map> queryCollect(int page, int size, HttpServletRequest request){
        PageHelper.startPage(page,size);
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        List<Collect> collects = collectZLXService.queryCollectByUserId(userId);
        List<WxGoods4> wxGoods4s = new ArrayList<>();

        for(Collect i:collects){
            WxGoods4 wxGoods4 = new WxGoods4();
            wxGoods4.trans(goodsService.queryGoodsById(i.getValueId()),i);
            wxGoods4s.add(wxGoods4);
        }

        PageInfo<WxGoods4> wxGoods4PageInfo= new PageInfo<>(wxGoods4s);
        Map<Object, Object> map = new HashMap<>();
        map.put("collectList",wxGoods4s);
        map.put("totalPages",wxGoods4PageInfo.getPageNum());
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }


    @RequestMapping("wx/collect/addordelete")
    @ResponseBody
    public ResponseVO<Map> addOrDelete(@RequestBody Map value, HttpServletRequest request){
        Integer valueId = (Integer) value.get("valueId");
        PageInfo<Goods> goodsPageInfo= new PageInfo<>();
        Map<Object, Object> map = new HashMap<>();
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        Collect collect = collectZLXService.queryCollectByGoodsId(userId, valueId);
        if (collect != null){
            map.put("type","delete");
            collectZLXService.updateDeletedFalse(collect.getId());
        }else {
            map.put("type","add");
            collectZLXService.addCollectByGoodsId(userId,valueId);
        }
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;

    }

}
