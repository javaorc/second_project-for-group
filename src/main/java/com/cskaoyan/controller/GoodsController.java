package com.cskaoyan.controller;

import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("admin")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("goods/list")
    @ResponseBody
    public ResponseVO<QueryList> queryList(int page, int limit, String sort, String order, String goodsSn, String name) {
        ResponseVO<QueryList> responseVO = new ResponseVO<>();

        if ("".equals(goodsSn))
            goodsSn = null;

        if ("".equals(name))
            name = null;

        QueryList queryList = goodsService.queryList(page, limit, sort, order, goodsSn, name);
        responseVO.setData(queryList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);

        return responseVO;
    }

}
