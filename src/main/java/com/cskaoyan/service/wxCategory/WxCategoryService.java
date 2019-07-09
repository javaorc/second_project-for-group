package com.cskaoyan.service.wxCategory;

import com.cskaoyan.bean.Category;

import java.util.List;

public interface WxCategoryService {
    List<Category> queryParentCategories();

    List<Category> querySubCategories(int pid);

    Category queryCategoryById(int id);
}
