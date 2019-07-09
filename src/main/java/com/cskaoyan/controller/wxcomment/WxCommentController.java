//package com.cskaoyan.controller.wxcomment;
//
//import com.cskaoyan.service.wxcommentservice.WxCommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "wx/comment/")
//public class WxCommentController {
//
//    @Autowired
//    WxCommentService wxCommentService;
//
//    @RequestMapping(value = "list")
//    public ResponseVO<QueryList> queryList(int page, int limit, String sort, String order, String userId, String valueId) {
//        if ("".equals(userId)){
//            userId = null;
//        }
//        if ("".equals(valueId)){
//            valueId = null;
//        }
//        ResponseVO<QueryList> responseVO = new ResponseVO<>();
//        QueryList queryList = commentService.queryList(page, limit, sort, order, userId, valueId);
//        responseVO.setData(queryList);
//        responseVO.setErrmsg("成功");
//        responseVO.setErrno(0);
//        return responseVO;
//    }
//}
//valueId=1181000&type=0&size=20&page=1&showType=0