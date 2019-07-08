package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Topic;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.mapper.generalize.TopicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 14:16
 **/
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();

    Map<String, Object> map = new HashMap<>();

    @Override
    public ResponseVO<Map<String, Object>> topicList(String title, String subtitle,
                                                     int page,int limit) {
        if("".equals(title)){
            title=null;
        }if("".equals(subtitle)){
            subtitle=null;
        }

        List<Topic> topicList = topicMapper.topicList(title, subtitle);
        //分页
        PageHelper.startPage(page,limit);
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topicList);
        map.put("total",topicPageInfo.getTotal());
        map.put("items", topicList);
        //封装
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
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

    @Override
    public List<Topic> queryTopics() {
        return topicMapper.queryTopics();
    }
}
