package com.cskaoyan.controller.wxgroupon;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxgroupon.WxGrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:40
 **/
@Controller
@RequestMapping("wx")
public class WxGrouponController {

    @Autowired
    WxGrouponService grouponService;

    ResponseVO<Map<String,Object>> mapResponseVO = new ResponseVO<>();

    @RequestMapping("groupon/list")
    @ResponseBody
    public ResponseVO<Map<String,Object>> gouponList(int page,int size){
        return grouponService.gouponList(page,size);
    }
}
