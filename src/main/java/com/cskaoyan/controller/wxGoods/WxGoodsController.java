package com.cskaoyan.controller.wxGoods;


import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxGoods.WxCategoryGoodsServiceImpl;
import com.cskaoyan.service.wxGoods.WxGoodsServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WxGoodsController {
    @Autowired
    WxGoodsServiceImpl goodsService;

    @Autowired
    WxCategoryGoodsServiceImpl wxCategoryGoodsService;
    

    @RequestMapping("wx/goods/list")
    @ResponseBody
    public ResponseVO<Map> queryGoodsList(Integer categoryId,int page,int size){
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        List<Category> categories = wxCategoryGoodsService.queryBrotherCategory(categoryId);
        List<Goods> goods = goodsService.queryGoodsByCategoryId(categoryId);
        Map<Object, Object> map = new HashMap<>();
        map.put("filterCategoryList",categories);
        map.put("goodsList",goods);
        map.put("count",goods.size());
        mapResponseVO.setData(map);
        return mapResponseVO;

    }
}
