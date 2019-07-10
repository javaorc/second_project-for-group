package com.cskaoyan.mapper.wxTopicZLX;

import com.cskaoyan.bean.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxTopicZLXMapper {
    List<Topic> queryTopic();
    Topic queryTopicDetail(@Param("id")int id);
}
