package com.cskaoyan.mapper.mallManege;

import com.cskaoyan.bean.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallBrandMapper {
    List<Brand> showBrand();

    int deleteBrand(@Param("brand") Brand brand);

    List<Brand> searchBrandByIdAndName(@Param("id")String id,@Param("name")String name);

    int updateBrandByBid(@Param("brand") Brand brand);

    int insertBrand(@Param("brand") Brand brand);

}
