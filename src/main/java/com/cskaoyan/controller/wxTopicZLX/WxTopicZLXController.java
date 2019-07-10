package com.cskaoyan.controller.wxTopicZLX;


import com.cskaoyan.bean.Topic;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxTopicZLX.WxTopicZLXServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WxTopicZLXController {
    @Autowired
    WxTopicZLXServiceImpl topicZLXService;


    @RequestMapping("wx/topic/list")
    @ResponseBody
    public ResponseVO<Map> queryTopic(Integer page,Integer size){
        PageHelper.startPage(page,size);
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        List<Topic> topics = topicZLXService.queryTopic();
        PageInfo<Topic> topicPageInfo= new PageInfo<>(topics);
        Map<Object, Object> map = new HashMap<>();
        map.put("count",topicPageInfo.getTotal());
        map.put("data",topics);
        mapResponseVO.setErrno(0);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setData(map);
        return mapResponseVO;
    }


    @RequestMapping("wx/topic/detail")
    @ResponseBody
    public ResponseVO<Map> queryTopicDetail(Integer id){
        ResponseVO<Map> mapResponseVO = new ResponseVO<>();
        Topic topic = topicZLXService.queryTopicDetail(id);
        Map<Object, Object> map = new HashMap<>();
        map.put("goods",topic.getGoods());
        map.put("topic",topic);
        mapResponseVO.setErrno(0);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setData(map);
        return mapResponseVO;
    }

    @RequestMapping("wx/topic/related")
    @ResponseBody
    public ResponseVO<List<Topic>> queryTopicRelated(Integer id){
        ResponseVO<List<Topic>> mapResponseVO = new ResponseVO<>();
        List<Topic> topics = topicZLXService.queryTopic();
        List<Topic> related = new ArrayList<>();
        related.add(topics.get(0));
        related.add(topics.get(1));
        related.add(topics.get(2));
        related.add(topics.get(3));

        mapResponseVO.setErrno(0);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setData(related);
        return mapResponseVO;
    }
}
