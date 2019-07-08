package com.cskaoyan.controller;

import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "admin/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "list")
    public ResponseVO<QueryList> queryList(int page, int limit, String sort, String order, String username, String id) {
        if ("".equals(username)){
            username = null;
        }
        if ("".equals(id)){
            id = null;
        }
        ResponseVO<QueryList> responseVO = new ResponseVO<>();
        QueryList queryList = feedbackService.queryList(page, limit, sort, order, username, id);
        responseVO.setData(queryList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

}
