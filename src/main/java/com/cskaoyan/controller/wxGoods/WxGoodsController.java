package com.cskaoyan.controller.wxGoods;


import com.cskaoyan.bean.*;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxGoods.WxCategoryGoodsServiceImpl;
import com.cskaoyan.service.wxGoods.WxGoodsServiceImpl;
import com.cskaoyan.service.wxGoods.WxSearchHistoryServiceImpl;
import com.cskaoyan.tokenManager.UserTokenManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WxGoodsController {
    @Autowired
    WxGoodsServiceImpl goodsService;

    @Autowired
    WxCategoryGoodsServiceImpl categoryGoodsService;

    @Autowired
    WxSearchHistoryServiceImpl searchHistoryService;

    @RequestMapping("wx/goods/category")
    @ResponseBody
    public ResponseVO<Map> queryCategoryById(int id){
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        Map<Object, Object> map = new HashMap<>();
        Category currentCategory;
        Category parentCategory;
        Category category = categoryGoodsService.queryCategoryById(id);
        if ("L2".equals(category.getLevel())){
            currentCategory = category;
            parentCategory = categoryGoodsService.queryCategoryById(currentCategory.getPid());
        }else {
            parentCategory = category;
            currentCategory = categoryGoodsService.queryCategoryByPid(parentCategory.getId()).get(0);
        }
        List<Category> brotherCategory = categoryGoodsService.queryBrotherCategory(currentCategory.getId());
        map.put("brotherCategory",brotherCategory);
        map.put("parentCategory",parentCategory);
        map.put("currentCategory",currentCategory);
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
    }


    @RequestMapping("wx/goods/list")
    @ResponseBody
    public ResponseVO<Map> queryGoodsList(String keyword, Integer brandId , Integer categoryId, int page, int size, HttpServletRequest request){
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        List<Goods> goods;
        List<Category> categories = null;
        Integer userId = 1;
        if (categoryId != null&& categoryId != 0){
            categories = categoryGoodsService.queryBrotherCategory(categoryId);
            goods = goodsService.queryGoodsByCategoryId(categoryId);
        }else if (brandId != null){
            goods = goodsService.queryGoodsByBrandId(brandId);
            categories = categoryGoodsService.queryBrotherCategory(goods.get(0).getCategoryId());
        }else {
            String tokenKey = request.getHeader("X-Litemall-Token");
            userId = UserTokenManager.getUserId(tokenKey);
            searchHistoryService.addSearchHistory(keyword,userId);
            goods = goodsService.queryGoodsByName(keyword);
            categories = categoryGoodsService.queryBrotherCategory(goods.get(0).getCategoryId());
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("filterCategoryList",categories);
        map.put("goodsList",goods);
        map.put("count",goods.size());
        mapResponseVO.setData(map);
        return mapResponseVO;
    }
}
