package com.cskaoyan.controller;

import com.cskaoyan.OperationLog.OperationLog;
import com.cskaoyan.bean.Issue;
import com.cskaoyan.bean.Kind;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.MallIssueService;
import com.cskaoyan.service.SystemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class MallIssueController {
    @Autowired(required = false)
    MallIssueService mallIssueService;
    @Autowired
    SystemService systemService;

    @RequestMapping("issue/list")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:list")

    public ResponseVO<Map<String,Object>> showAllIssueAndSearch(Integer page,Integer limit,String question){
        PageHelper.startPage(page,limit);
        Map<String,Object> listMap=new HashMap<>();
        if(question==null){
            List<Issue> issues = mallIssueService.queryAllIssue();
            PageInfo<Issue> issuePageInfo = new PageInfo<>(issues);
            listMap.put("items",issues);
            listMap.put("total",issuePageInfo.getTotal());
            }
        else{
            List<Issue> issues = mallIssueService.searchByQuestion(question);
            PageInfo<Issue> issuePageInfo = new PageInfo<>(issues);
            listMap.put("items",issues);
            listMap.put("total",issuePageInfo.getTotal());
        }
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"显示对象",name1);
        ResponseVO<Map<String,Object>> responseVO = new ResponseVO<>();
        responseVO.setData(listMap);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping("issue/create")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:insert")
    public ResponseVO<Issue> createIssue(@RequestBody Issue issue) {
        Date date = new Date(System.currentTimeMillis());
        issue.setAddTime(date);
        issue.setUpdateTime(date);
        int i = mallIssueService.insetIssue(issue);
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"创建对象",name1);
        if (i > 0) {
            ResponseVO<Issue> responseVO = new ResponseVO<>();
            responseVO.setData(issue);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }

    @RequestMapping("issue/update")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:update")
    public ResponseVO<Issue> updateIssue(@RequestBody Issue issue) {
        Date date = new Date(System.currentTimeMillis());
        issue.setUpdateTime(date);
        int i = mallIssueService.updateIssue(issue);
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"更新对象",name1);
        if (i > 0) {
            ResponseVO<Issue> responseVO = new ResponseVO<>();
            responseVO.setData(issue);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }
    @RequestMapping("issue/delete")
    @ResponseBody
    @RequiresPermissions(value = "admin:storage:delete")
    public ResponseVO<Issue> deleteIssue(@RequestBody Issue issue) {

        int i = mallIssueService.deleteIssue(issue);
        String name1 = (String) SecurityUtils.getSubject().getPrincipal();
        OperationLog operationLog=new OperationLog();
        operationLog.logInsert(systemService,"删除对象",name1);
        if (i > 0) {
            ResponseVO<Issue> responseVO = new ResponseVO<>();
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }

    }
