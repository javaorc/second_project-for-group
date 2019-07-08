package com.cskaoyan.service;

import com.cskaoyan.bean.vo.QueryList;

public interface FeedbackService {

    QueryList queryList(int page, int limit, String sort, String order, String username, String id);

}
