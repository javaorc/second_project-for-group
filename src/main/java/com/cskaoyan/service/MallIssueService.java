package com.cskaoyan.service;

import com.cskaoyan.bean.Issue;

import java.util.List;

public interface MallIssueService {
    List<Issue> queryAllIssue();

    List<Issue> searchByQuestion(String question);

    int insetIssue(Issue issue);

    int updateIssue(Issue issue);

    int deleteIssue(Issue issue);
}
