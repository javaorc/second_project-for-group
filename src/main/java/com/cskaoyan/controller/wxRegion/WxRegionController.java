package com.cskaoyan.controller.wxRegion;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxRegion.WxRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WxRegionController {

    @Autowired
    WxRegionService regionService;

    @RequestMapping("wx/region/list")
    @ResponseBody
    public ResponseVO<List> queryRegionList(int pid) {
        ResponseVO<List> responseVO = new ResponseVO<>();
        responseVO.setData(regionService.queryRegionListByPid(pid));
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

}
