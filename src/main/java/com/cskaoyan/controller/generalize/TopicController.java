package com.cskaoyan.controller.generalize;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Topic;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.SystemService;
import com.cskaoyan.service.generalize.TopicService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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

    @Autowired
    SystemService systemService;

    @RequestMapping("topic/list")
    @ResponseBody
    public ResponseVO<Map<String, Object>> topicList(String title, String subtitle,
                                                     int page, int limit, String sort, String order) {
        return topicService.topicList(title, subtitle,page,limit);
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
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"update专题",name);
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
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"delete专题",name);
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
            String name = (String) SecurityUtils.getSubject().getPrincipal();
            OperationLog operationLog=new OperationLog();
            operationLog.logInsert(systemService,"create专题",name);
            return topicResponseVO;
        }
        return null;
    }
}
