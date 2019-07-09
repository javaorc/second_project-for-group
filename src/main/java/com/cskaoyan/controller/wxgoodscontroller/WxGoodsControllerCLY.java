package com.cskaoyan.controller.wxgoodscontroller;

import com.cskaoyan.bean.vo.GoodsQuery;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxGoods;
import com.cskaoyan.bean.wxBean.WxGoods2;
import com.cskaoyan.bean.wxBean.WxGoods3;
import com.cskaoyan.service.wxgoodsservice.WxGoodsServiceCLY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "wx/goods")
public class WxGoodsControllerCLY {

    @Autowired
    WxGoodsServiceCLY wxGoodsServiceCLY;

    @RequestMapping(value = "detail")
    public ResponseVO<GoodsQuery> getDetail(String id){
        ResponseVO<GoodsQuery> responseVO = new ResponseVO<>();
        GoodsQuery container = wxGoodsServiceCLY.getDetail(id);
        responseVO.setData(container);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

//    @RequestMapping(value = "related")
//    public ResponseVO<List<WxGoods2>> getRelated(String id){
//        ResponseVO<List<WxGoods2>> responseVO = new ResponseVO<>();
//        List<WxGoods2> goodsList = wxGoodsServiceCLY.getRelated(id);
//        WxGoods3 wxGoods3 = new WxGoods3(goodsList) ;
//        responseVO.setData(wxGoods3.getList());
//        responseVO.setErrmsg("成功");
//        responseVO.setErrno(0);
//        return responseVO;
//    }

    @RequestMapping(value = "related")
    public Map getRelated(String id){
//        ResponseVO<WxGoods3> responseVO = new ResponseVO<>();
        ResponseVO<List<WxGoods2>> responseVO = new ResponseVO<>();
        List<WxGoods2> goodsList = wxGoodsServiceCLY.getRelated(id);
//        WxGoods3 wxGoods3 = new WxGoods3(goodsList) ;
//        responseVO.setData(wxGoods3.getList());
        Map map=new HashMap();
        Map map1=new HashMap();
        map1.put("goodsList",goodsList);
        map.put("data",map1);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

}