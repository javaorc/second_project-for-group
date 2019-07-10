package com.cskaoyan.service.wxTopicZLX;

import com.cskaoyan.bean.Topic;

import java.util.List;

public interface WxTopicZLXService {
    List<Topic> queryTopic();
    Topic queryTopicDetail(int id);
}
