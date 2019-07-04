package com.cskaoyan.Service;

import com.cskaoyan.bean.Brand;

import java.util.List;

public interface MallBrandService {
    List<Brand> showBrand();

    int deleteBrand(Brand brand);

    List<Brand> searchBrandByIdAndName(String id,String name);
}
