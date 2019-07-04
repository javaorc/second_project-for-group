package com.cskaoyan.service;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Kind;

import java.util.List;

public interface MallCategoryService {
    List<Kind> showAllCategory();

    int deleteCategory(Category category);

    List<Kind> showKindCategory();

    int createCategory(Category category);

    int updateCategory(Category category);
}
