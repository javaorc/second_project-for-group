package com.cskaoyan.service;

import com.cskaoyan.bean.Feedback;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public QueryList queryList(int page, int limit, String sort, String order, String username, String id) {
        int total = feedbackMapper.queryTotal(username,id);
        int offset = (page - 1) * limit;
        List<Feedback> items = feedbackMapper.queryList(limit, offset, sort, order,username,id);
        QueryList queryList = new QueryList();
        queryList.setTotal(total);
        queryList.setItems(items);
        return queryList;
    }

}
