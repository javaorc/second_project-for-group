package com.cskaoyan.service;

import com.cskaoyan.bean.Comment;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public ResponseVO deleteById(Comment comment) {
        ResponseVO responseVO = new ResponseVO();
        commentMapper.deleteOne(comment);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @Override
    public QueryList queryList(int page, int limit, String sort, String order, String userId, String valueId) {
        int total = commentMapper.queryTotal(userId,valueId);
        int offset = (page - 1) * limit;
        List<Comment> items = commentMapper.queryList(limit, offset, sort, order,userId,valueId);
        QueryList queryList = new QueryList();
        queryList.setTotal(total);
        queryList.setItems(items);
        return queryList;
    }

}
