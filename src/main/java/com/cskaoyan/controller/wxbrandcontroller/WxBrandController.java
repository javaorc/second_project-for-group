package com.cskaoyan.controller.wxbrandcontroller;

import com.cskaoyan.bean.vo.BrandQuery;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.wxbrandservice.WxBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "wx/brand")
public class WxBrandController {

    @Autowired
    WxBrandService brandService;

    @RequestMapping(value = "list")
    public ResponseVO<BrandQuery> getList(int page, int size){
        ResponseVO<BrandQuery> responseVO = new ResponseVO<>();
        BrandQuery brandQuery = brandService.getList(page,size);
        responseVO.setData(brandQuery);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

}
