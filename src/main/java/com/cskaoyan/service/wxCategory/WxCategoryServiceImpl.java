package com.cskaoyan.service.wxCategory;

import com.cskaoyan.bean.Category;
import com.cskaoyan.mapper.wxCategory.WxCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCategoryServiceImpl implements WxCategoryService {

    @Autowired
    WxCategoryMapper categoryMapper;

    @Override
    public List<Category> queryParentCategories() {
        return categoryMapper.queryParentCategories();
    }

    @Override
    public List<Category> querySubCategories(int pid) {
        return categoryMapper.querySubCategories(pid);
    }

    @Override
    public Category queryCategoryById(int id) {
        return categoryMapper.queryCategoryById(id);
    }
}
