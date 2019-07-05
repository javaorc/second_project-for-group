package com.cskaoyan.controller;

import com.cskaoyan.bean.Issue;
import com.cskaoyan.bean.Kind;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.MallIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class MallIssueController {
    @Autowired(required = false)
    MallIssueService mallIssueService;

    @RequestMapping("issue/list")
    @ResponseBody
    public ResponseVO<Map<String,Object>> showAllCategory(){
        List<Issue> issues = mallIssueService.queryAllIssue();
        Map<String,Object> listMap=new HashMap<>();
        listMap.put("items",issues);
        listMap.put("total",issues.size());
        ResponseVO<Map<String,Object>> responseVO = new ResponseVO<>();
        responseVO.setData(listMap);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
