package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Topic;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxTopic;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 14:16
 **/
public interface TopicService {
    ResponseVO<Map<String, Object>> topicList(String title, String subtitle,int page,int limit);

    int updateTopic(Topic topic);

    int deleteTopic(Topic topic);

    int insertTopic(Topic topic);

    List<WxTopic> queryTopics();
}
