package com.cskaoyan.controller.wxCollectZLX;


import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxCollectZLX.WxCollectZLXServiceImpl;
import com.cskaoyan.service.wxGoods.WxGoodsServiceImpl;
import com.cskaoyan.tokenManager.UserTokenManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        PageInfo<Goods> goodsPageInfo= new PageInfo<>();
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        List<Collect> collects = collectZLXService.queryCollectByUserId(userId);
        List<Goods> goods = new ArrayList<>();
        for(Collect i:collects){
            goods.add(goodsService.queryGoodsById(i.getValueId()));
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("collectList",goods);
        map.put("totalPages",goodsPageInfo.getPageNum());
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }
}