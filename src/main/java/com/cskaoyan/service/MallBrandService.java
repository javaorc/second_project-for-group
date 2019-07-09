package com.cskaoyan.service;

import com.cskaoyan.bean.Brand;
import com.cskaoyan.bean.wxBean.WxBrand;

import java.util.List;

public interface MallBrandService {
    List<Brand> showBrand();

    int deleteBrand(Brand brand);

    List<Brand> searchBrandByIdAndName(String id, String name);

    int updateBrandByBid( Brand brand);

    int insertBrand( Brand brand);

    List<WxBrand> queryBrands();
}
