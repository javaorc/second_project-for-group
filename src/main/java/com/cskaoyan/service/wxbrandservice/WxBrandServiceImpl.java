package com.cskaoyan.service.wxbrandservice;

import com.cskaoyan.bean.vo.BrandQuery;
import com.cskaoyan.mapper.wxbrandmapper.WxBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxBrandServiceImpl implements WxBrandService {

    @Autowired
    WxBrandMapper brandMapper;

    @Override
    public BrandQuery getList(int page, int size) {
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setBrandList(brandMapper.getList(page,size));
        brandQuery.setTotalPages(getTotalPages(size));
        return brandQuery;
    }

    public int getTotalPages(int size){
        int totalPage;
        int totalRecord;
        int maxResult;
        totalRecord = brandMapper.getTotal();
        maxResult = size;
        totalPage = (totalRecord + maxResult -1) / maxResult;
        return totalPage;
    }

}
