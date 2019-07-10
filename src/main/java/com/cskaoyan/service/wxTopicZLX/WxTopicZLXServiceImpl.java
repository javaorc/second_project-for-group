package com.cskaoyan.service.wxTopicZLX;

import com.cskaoyan.bean.Topic;
import com.cskaoyan.mapper.wxTopicZLX.WxTopicZLXMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WxTopicZLXServiceImpl implements WxTopicZLXService {
    @Autowired
    WxTopicZLXMapper topicZLXMapper;


    @Override
    public List<Topic> queryTopic() {
        List<Topic> topics = topicZLXMapper.queryTopic();
        return topics;
    }

    @Override
    public Topic queryTopicDetail(int id) {
        Topic topic = topicZLXMapper.queryTopicDetail(id);
        return topic;
    }
}
