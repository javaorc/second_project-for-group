package com.cskaoyan.service.wxgroupon;

import com.cskaoyan.bean.Feedback;
import com.cskaoyan.bean.vo.ResponseVO;

import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/8 15:43
 **/
public interface WxGrouponService {
    ResponseVO<Map<String, Object>> gouponList(int page, int size);

    ResponseVO<Map<String, Object>> gouponMy(Integer showType);

    ResponseVO<Map<String, Object>> gouponDetail(Integer grouponId);

    ResponseVO<Map<String, Object>> feedback(Map<String,Object> map);

    ResponseVO<Map<String, Object>> footprint(Integer page, Integer size);
}
