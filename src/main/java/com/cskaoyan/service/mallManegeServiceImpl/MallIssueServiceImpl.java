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
}
