package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Topic;
import com.cskaoyan.mapper.generalize.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 14:16
 **/
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Override
    public List<Topic> topicList(String title, String subtitle) {
        return topicMapper.topicList(title,subtitle);
    }

    @Override
    public int updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public int deleteTopic(Topic topic) {
        return topicMapper.deleteTopic(topic);
    }

    @Override
    public int insertTopic(Topic topic) {
        return topicMapper.insertTopic(topic);
    }
}
