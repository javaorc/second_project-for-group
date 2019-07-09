package com.cskaoyan.mapper.wxbrandmapper;

import com.cskaoyan.bean.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxBrandMapper {

    List<Brand> getList(@Param("page") int page,
                        @Param("size") int size);

    Integer getTotal();

}
