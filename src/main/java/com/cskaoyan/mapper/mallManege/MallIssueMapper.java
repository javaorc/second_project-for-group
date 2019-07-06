package com.cskaoyan.mapper.mallManege;

import com.cskaoyan.bean.Issue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallIssueMapper {
    List<Issue> queryAllIssue();

    List<Issue> searchByQuestion(@Param("ques")String question);

    int insetIssue(@Param("issue") Issue issue);

    int updateIssue(@Param("issue") Issue issue);

    int deleteIssue(@Param("issue")Issue issue);
}
