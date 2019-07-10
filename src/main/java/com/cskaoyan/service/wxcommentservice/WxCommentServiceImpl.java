package com.cskaoyan.service.wxcommentservice;

import com.cskaoyan.mapper.wxcommentmapper.WxCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxCommentServiceImpl implements WxCommentService {

    @Autowired
    WxCommentMapper wxCommentMapper;


}
