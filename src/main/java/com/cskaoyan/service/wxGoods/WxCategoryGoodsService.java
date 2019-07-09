package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.Category;

import java.util.List;

public interface WxCategoryGoodsService {
    List<Category> queryBrotherCategory(Integer categoryId);
    List<Category> queryBrotherCategoryByPid(Integer categoryPid);
    Category queryCategoryById(Integer categoryId);
    Category queryFirstCategoryByPid(Integer categoryPid);

}
