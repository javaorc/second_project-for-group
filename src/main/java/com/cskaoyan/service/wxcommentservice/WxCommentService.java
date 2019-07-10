package com.cskaoyan.service.wxcommentservice;

import com.cskaoyan.bean.vo.QueryCommentList;
import com.cskaoyan.bean.wxBean.WxComment2;
import com.cskaoyan.bean.wxBean.WxCount;

import java.util.List;

public interface WxCommentService {

    QueryCommentList<List<WxComment2>> queryList(String valueId, int type, int size,int page, int showType);

    WxCount getCount();

}
