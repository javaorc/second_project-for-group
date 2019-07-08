package com.cskaoyan.mapper.mallManege;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Kind;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallCategoryMapper {
    List<Kind> showAllCategory();

    int deleteCategory(@Param("category")Category category);

    List<Kind> showKindCategory();

    int createCategory(@Param("category")Category category);

    int updateCategory(@Param("category")Category category);

    List<Kind> queryKindCategories();
}
