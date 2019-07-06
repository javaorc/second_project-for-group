package com.cskaoyan.mapper.generalize;

import com.cskaoyan.bean.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 14:17
 **/
public interface TopicMapper {
    List<Topic> topicList(@Param("title") String title,
                          @Param("subtitle") String subtitle);

    int updateTopic(@Param("topic") Topic topic);

    int deleteTopic(@Param("topic") Topic topic);

    int insertTopic(@Param("topic") Topic topic);
}
