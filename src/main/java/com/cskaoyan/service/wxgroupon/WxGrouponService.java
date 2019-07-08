package com.cskaoyan.service.wxgroupon;

import com.cskaoyan.bean.vo.ResponseVO;

import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:43
 **/
public interface WxGrouponService {
    ResponseVO<Map<String, Object>> gouponList(int page, int size);
}
