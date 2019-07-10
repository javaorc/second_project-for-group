package com.cskaoyan.service.wxcommentservice;

import com.cskaoyan.bean.vo.QueryCommentList;

import com.cskaoyan.bean.wxBean.WxComment2;

import com.cskaoyan.bean.wxBean.WxCount;
import com.cskaoyan.mapper.wxcommentmapper.WxCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCommentServiceImpl implements WxCommentService {

    @Autowired
    WxCommentMapper wxCommentMapper;

    @Override
    public QueryCommentList<List<WxComment2>> queryList(String valueId, int type, int size,int page, int showType) {
        QueryCommentList<List<WxComment2>> queryCommentList = new QueryCommentList<>();
        if (showType == 1){
            queryCommentList.setCount(wxCommentMapper.queryCommentCountHasPic());
            List<WxComment2> list = wxCommentMapper.queryCommentListHasPic(valueId, type, size);
            queryCommentList.setData(list);
        }else if (showType == 0){
            queryCommentList.setCount(wxCommentMapper.queryCommentAllCount());
            List<WxComment2> list = wxCommentMapper.queryAllCommentList(valueId, type, size);
            queryCommentList.setData(list);
        }
        queryCommentList.setCurrentPage(page);
        return queryCommentList;
    }

    @Override
    public WxCount getCount() {
        WxCount wxCount = new WxCount();
        wxCount.setAllCount(wxCommentMapper.queryCommentAllCount());
        wxCount.setHasPicCount(wxCommentMapper.queryCommentCountHasPic());
        return wxCount;
    }



}
