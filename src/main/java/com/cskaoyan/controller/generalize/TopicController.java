package com.cskaoyan.controller.generalize;

import com.cskaoyan.bean.Topic;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.generalize.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/5 14:09
 **/
@Controller
@RequestMapping("admin")
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping("topic/list")
    @ResponseBody
    public ResponseVO<Map<String, Object>> topicList(String title, String subtitle,
                                                     int page, int limit, String sort, String order) {
        ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        List<Topic> topicList = topicService.topicList(title, subtitle);
        Map<String, Object> map = new HashMap<>();
        map.put("items", topicList);
        map.put("total", topicList.size());
        mapResponseVO.setData(map);
        return mapResponseVO;
    }

    @RequestMapping("topic/update")
    @ResponseBody
    public ResponseVO<Topic> updateTopic(@RequestBody Topic topic) {
        ResponseVO<Topic> topicResponseVO = new ResponseVO<>();
        topicResponseVO.setErrmsg("成功");
        topicResponseVO.setErrno(0);
        topic.setUpdateTime(new Date());
        int i = topicService.updateTopic(topic);
        if (i == 1) {
            topicResponseVO.setData(topic);
            return topicResponseVO;
        }
        return null;
    }

    @RequestMapping("topic/delete")
    @ResponseBody
    public ResponseVO<Object> deleteTopic(@RequestBody Topic topic) {
        ResponseVO<Object> topicResponseVO = new ResponseVO<>();
        int i = topicService.deleteTopic(topic);
        if (i == 1) {
            topicResponseVO.setErrmsg("成功");
            topicResponseVO.setErrno(0);
            return topicResponseVO;
        }
        return null;
    }

    @RequestMapping("topic/create")
    @ResponseBody
    public ResponseVO<Topic> insertTopic(@RequestBody Topic topic){
        ResponseVO<Topic> topicResponseVO = new ResponseVO<>();
        topicResponseVO.setErrmsg("成功");
        topicResponseVO.setErrno(0);
        Date date = new Date();
        topic.setAddTime(date);
        topic.setUpdateTime(date);
        int i =topicService.insertTopic(topic);
        if(i==1){
            topicResponseVO.setData(topic);
            return topicResponseVO;
        }
        return null;
    }
}