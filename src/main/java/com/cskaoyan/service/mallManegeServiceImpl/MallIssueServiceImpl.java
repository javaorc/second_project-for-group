package com.cskaoyan.service.mallManegeServiceImpl;

import com.cskaoyan.bean.Issue;
import com.cskaoyan.mapper.mallManege.MallIssueMapper;
import com.cskaoyan.service.MallIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MallIssueServiceImpl implements MallIssueService {
    @Autowired(required = false)
    MallIssueMapper mallIssueMapper;

    @Override
    public List<Issue> queryAllIssue() {
        return mallIssueMapper.queryAllIssue();
    }

    @Override
    public List<Issue> searchByQuestion(String question) {
        return mallIssueMapper.searchByQuestion(question);
    }

    @Override
    public int insetIssue(Issue issue) {
        return mallIssueMapper.insetIssue(issue);
    }

    @Override
    public int updateIssue(Issue issue) {
        return mallIssueMapper.updateIssue(issue);
    }

    @Override
    public int deleteIssue(Issue issue) {
        return mallIssueMapper.deleteIssue(issue);
    }
}
