package com.cskaoyan.service.wxGoods;

import com.cskaoyan.bean.Category;
import com.cskaoyan.mapper.wxGoods.WxCategoryGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCategoryGoodsServiceImpl implements WxCategoryGoodsService {
    @Autowired
    WxCategoryGoodsMapper wxCategoryGoodsMapper;
    @Override
    public List<Category> queryBrotherCategory(Integer categoryId) {
        int categoryPid = wxCategoryGoodsMapper.queryCategoryPidById(categoryId);
        List<Category> categories = wxCategoryGoodsMapper.queryCategoryByPid(categoryPid);
        return categories;
    }

    @Override
    public List<Category> queryBrotherCategoryByPid(Integer categoryPid) {
        List<Category> categories = wxCategoryGoodsMapper.queryCategoryByPid(categoryPid);
        return categories;
    }

    @Override
    public Category queryCategoryById(Integer categoryId) {
        Category category = wxCategoryGoodsMapper.queryCategoryById(categoryId);
        return category;
    }

    @Override
    public Category queryFirstCategoryByPid(Integer categoryPid) {
        Category category = wxCategoryGoodsMapper.queryFirstCategoryByPid(categoryPid);
        return category;
    }


}
