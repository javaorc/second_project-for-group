package com.cskaoyan.controller;

import com.cskaoyan.bean.Comment;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "admin/comment")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "delete")
    public ResponseVO delete(Comment comment){
        ResponseVO responseVO = commentService.deleteById(comment);
        return responseVO;
    }

    @RequestMapping(value = "list")
    public ResponseVO<QueryList> queryList(int page, int limit, String sort, String order, String userId, String valueId) {
        if ("".equals(userId)){
            userId = null;
        }
        if ("".equals(valueId)){
            valueId = null;
        }
        ResponseVO<QueryList> responseVO = new ResponseVO<>();
        QueryList queryList = commentService.queryList(page, limit, sort, order, userId, valueId);
        responseVO.setData(queryList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

}
