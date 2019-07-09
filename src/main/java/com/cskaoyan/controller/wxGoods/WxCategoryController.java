package com.cskaoyan.controller.wxGoods;


import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxGoods.WxCategoryGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WxCategoryController {

    @Autowired
    WxCategoryGoodsServiceImpl categoryGoodsService;

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
}
