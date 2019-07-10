package com.cskaoyan.mapper.wxcommentmapper;

import com.cskaoyan.bean.vo.QueryCommentList;
import com.cskaoyan.bean.wxBean.WxComment2;

import java.util.List;

public interface WxCommentMapper {

    List<WxComment2> queryAllCommentList(String valueId, int type, int size);

    List<WxComment2> queryCommentListHasPic(String valueId, int type, int size);

    int queryCommentAllCount();

    int queryCommentCountHasPic();


}
