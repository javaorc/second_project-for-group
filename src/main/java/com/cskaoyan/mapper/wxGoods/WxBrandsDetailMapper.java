package com.cskaoyan.mapper.wxGoods;

import com.cskaoyan.bean.Brand;
import org.apache.ibatis.annotations.Param;

public interface WxBrandsDetailMapper {
    public Brand queryBrandsDetailById(@Param("id") int id);
}
