package com.cskaoyan.controller.wxSearch;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.vo.ResponseVO2;
import com.cskaoyan.service.wxSearch.WxSearchService;
import com.cskaoyan.tokenManager.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WxSearchController {

    @Autowired
    WxSearchService searchService;

    /*进入页面*/
    @RequestMapping("wx/search/index")
    @ResponseBody
    public ResponseVO<Map> index(HttpServletRequest request) {

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        ResponseVO<Map> responseVO = new ResponseVO<>();

        responseVO.setData(searchService.queryKeywordList(userId));
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);

        return responseVO;
    }

    /*清除关键字历史记录*/
    @RequestMapping("wx/search/clearhistory")
    @ResponseBody
    public ResponseVO2 clearHistory(HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        ResponseVO2 responseVO = new ResponseVO2();

        int ret = searchService.clearHistoryKeyword(userId);

        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    /*异步搜索*/
    @RequestMapping("wx/search/helper")
    @ResponseBody
    public ResponseVO<List> helper() {
        ResponseVO<List> responseVO = new ResponseVO<>();

        List data = new ArrayList();

        responseVO.setData(data);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
