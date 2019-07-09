package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.Category;

import java.util.List;

public interface WxCategoryGoodsService {
    List<Category> queryBrotherCategory(Integer categoryId);

    List<Category> queryCategoryByPid(Integer categoryPid);
    Category queryCategoryById(Integer categoryId);


}
