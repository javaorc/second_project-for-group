package com.cskaoyan.controller;
import com.cskaoyan.bean.Keyword;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KeywordController {
    @Autowired
    KeywordService keywordService;

@RequestMapping("hello")
    @ResponseBody
    public String hello(){
    return "hello";
}


@RequestMapping("admin/keyword/list")
@ResponseBody
public ResponseVO<Map<String, Object>>  queryAllKeywordList(String keyword,String url) {
    
    ResponseVO<Map<String, Object>> ResponseVO = new ResponseVO<>();
    ResponseVO.setErrmsg("成功");
    ResponseVO.setErrno(0);
    List<Keyword> queryAllKeywordList = keywordService.queryAllKeywordList(keyword,url);
    int total = queryAllKeywordList.size();
    Map<String, Object> keywordMap = new HashMap<>();
    keywordMap.put("total", total);
    keywordMap.put("items",queryAllKeywordList);
    ResponseVO.setData(keywordMap);
    return ResponseVO;
}

    @RequestMapping("admin/keyword/update")
    @ResponseBody
        public ResponseVO<Keyword> updateKeyword(@RequestBody Keyword keyword) {
        ResponseVO<Keyword> keywordResponseVO = new ResponseVO<>();
        keywordResponseVO.setErrno(0);
        keywordResponseVO.setErrmsg("成功");
        int i = keywordService.updateKeyword(keyword.getId(),keyword.getKeyword(),keyword.getUrl(),keyword.getIsHot(),keyword.getIsDefault());
        if (i == 1) {
            keywordResponseVO.setData(keyword);
            return keywordResponseVO;
        }
        return null;
    }
    @RequestMapping("admin/keyword/delete")
    @ResponseBody
    public ResponseVO<Keyword> deleteKeyword(@RequestBody Keyword keyword){

    ResponseVO<Keyword> keywordResponseVO = new ResponseVO<>();
    keywordResponseVO.setErrno(0);
    keywordResponseVO.setErrmsg("成功");
    int i = keywordService.deleteKeyword(keyword.getId());
    if (i == 1) {
        keywordResponseVO.setData(keyword);
        return keywordResponseVO;
    }
    return null;
}
@RequestMapping("admin/keyword/create")
@ResponseBody
public ResponseVO<Keyword> insertKeyword(@RequestBody Keyword keyword){

    ResponseVO<Keyword> keywordResponseVO = new ResponseVO<>();
    keywordResponseVO.setErrno(0);
    keywordResponseVO.setErrmsg("成功");
    int i = keywordService.insertKeyword(keyword);
    if (i == 1) {
        keywordResponseVO.setData(keyword);
        return keywordResponseVO;
    }
    return null;
}
}

