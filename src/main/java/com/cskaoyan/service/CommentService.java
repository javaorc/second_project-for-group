package com.cskaoyan.service;

import com.cskaoyan.bean.Comment;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.ResponseVO;

public interface CommentService {

    ResponseVO deleteById(Comment comment);

    QueryList queryList(int page, int limit, String sort, String order, String userId, String valueId);

}
