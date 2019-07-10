package com.cskaoyan.service.wxbrandservice;

import com.cskaoyan.bean.vo.BrandQuery;

public interface WxBrandService {

    BrandQuery getList(int page, int size);

}
