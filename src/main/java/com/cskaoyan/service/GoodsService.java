package com.cskaoyan.service;

import com.cskaoyan.bean.vo.QueryList;

public interface GoodsService {

    QueryList queryList(int page, int limit, String sort, String order, String goodsSn, String name);


}
