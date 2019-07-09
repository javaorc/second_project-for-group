package com.cskaoyan.service.mallManegeServiceImpl;

import com.cskaoyan.bean.wxBean.WxBrand;
import com.cskaoyan.service.MallBrandService;
import com.cskaoyan.bean.Brand;
import com.cskaoyan.mapper.mallManege.MallBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallBrandServiceImpl implements MallBrandService {
    @Autowired(required = false)
    MallBrandMapper mallBrandMapper;

    @Override
    public List<Brand> showBrand() {
        return mallBrandMapper.showBrand();
    }

    @Override
    public int deleteBrand(Brand brand) {
        return mallBrandMapper.deleteBrand(brand);
    }

    @Override
    public List<Brand> searchBrandByIdAndName(String id, String name) {
        return mallBrandMapper.searchBrandByIdAndName(id,name);
    }

    @Override
    public int updateBrandByBid(Brand brand) {
        return mallBrandMapper.updateBrandByBid(brand);
    }

    @Override
    public int insertBrand(Brand brand) {
        return mallBrandMapper.insertBrand(brand);
    }

    @Override
    public List<WxBrand> queryBrands() {
        return mallBrandMapper.queryBrands();
    }
}
