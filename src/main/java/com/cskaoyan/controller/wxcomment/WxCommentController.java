package com.cskaoyan.controller.wxcomment;

import com.cskaoyan.bean.vo.QueryCommentList;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxComment2;
import com.cskaoyan.bean.wxBean.WxCount;
import com.cskaoyan.service.wxcommentservice.WxCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "wx/comment/")
public class WxCommentController {

    @Autowired
    WxCommentService wxCommentService;

    @RequestMapping(value = "list")
    public ResponseVO<QueryCommentList<List<WxComment2>>> getList(String valueId, int type, int size, int page, int showType) {
        ResponseVO<QueryCommentList<List<WxComment2>>> responseVO = new ResponseVO<>();
        QueryCommentList QueryCommentList = wxCommentService.queryList(valueId,type,size,page,showType);
        responseVO.setData(QueryCommentList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping(value = "count")
    public ResponseVO<WxCount> getCount(){
        ResponseVO<WxCount> responseVO = new ResponseVO<>();
        WxCount wxCount = wxCommentService.getCount();
        responseVO.setData(wxCount);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping(value = "post")
    public void doPost(){

    }

}
