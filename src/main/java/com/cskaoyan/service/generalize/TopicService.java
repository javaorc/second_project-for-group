package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Topic;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 14:16
 **/
public interface TopicService {
    List<Topic> topicList(String title, String subtitle);

    int updateTopic(Topic topic);

    int deleteTopic(Topic topic);

    int insertTopic(Topic topic);
}
