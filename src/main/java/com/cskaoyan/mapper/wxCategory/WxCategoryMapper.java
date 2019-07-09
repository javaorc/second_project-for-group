package com.cskaoyan.mapper.wxCategory;

import com.cskaoyan.bean.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxCategoryMapper {

    List<Category> queryParentCategories();

    List<Category> querySubCategories(@Param("pid") int pid);

    Category queryCategoryById(@Param("id") int id);
}
