package com.cskaoyan.mapper.wxGoods;

import com.cskaoyan.bean.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxCategoryGoodsMapper {
    int queryCategoryPidById(@Param("categoryId")int categoryId);
    List<Category> queryCategoryByPid(@Param("categoryPid")int categoryPid);
    Category queryCategoryById(@Param("categoryId")int categoryId);
}
