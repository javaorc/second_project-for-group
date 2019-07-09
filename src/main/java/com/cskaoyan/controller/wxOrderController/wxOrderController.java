package com.cskaoyan.controller.wxOrderController;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderGoods;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxOrder;
import com.cskaoyan.bean.wxBean.WxOrderDetail;
import com.cskaoyan.mapper.wxOrder.WxOrderMapper;
import com.cskaoyan.service.MallOrderService;
import com.cskaoyan.service.wxLoginAndRegister.WxLoginService;
import com.cskaoyan.service.wxOrder.WxOrderService;
import com.cskaoyan.tokenManager.UserTokenManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class wxOrderController {
    @Autowired
    WxLoginService wxLoginService;
    @Autowired
    WxOrderService wxOrderService;
    @RequestMapping("wx/order/list")
    @ResponseBody
    public ResponseVO<Map<Object,Object>> getOrder(Integer page,Integer size,Integer showType,HttpServletRequest request){
        //PageHelper.startPage(page,size);
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //List<Order> orders = wxLoginService.queryOrderByUid(userId);
        List<WxOrder> orders1 = wxOrderService.showOrders(userId);
        for(int i=0;i<orders1.size();i++){
            orders1.get(i).setGroupin(false);
            if(orders1.get(i).getOrderStatus()==101){
                orders1.get(i).setOrderStatusText("待支付");
            }else if(orders1.get(i).getOrderStatus()==102){
                orders1.get(i).setOrderStatusText("已取消");
            }else if(orders1.get(i).getOrderStatus()==103){
                orders1.get(i).setOrderStatusText("已取消（系统）");
            }
            else if(orders1.get(i).getOrderStatus()==201){
                orders1.get(i).setOrderStatusText("已付款");
            }else if(orders1.get(i).getOrderStatus()==202){
                orders1.get(i).setOrderStatusText("已取消");
            }
            else if(orders1.get(i).getOrderStatus()==301){
                orders1.get(i).setOrderStatusText("已发货");
            }else if(orders1.get(i).getOrderStatus()==401){
                orders1.get(i).setOrderStatusText("已收货");
            }else if(orders1.get(i).getOrderStatus()==402){
                orders1.get(i).setOrderStatusText("已收货");
            }
        }
        List<WxOrder> orders=new ArrayList<>();
        if(showType==0){
            orders=orders1;
        }else if(showType==1){
            for(WxOrder order:orders1){
                if(order.getOrderStatus()==101){
                    orders.add(order);
                }
            }
        }else if(showType==2) {
            for (WxOrder order : orders1) {
                if (order.getOrderStatus() == 201) {
                    orders.add(order);
                }
            }
        }else if(showType==3) {
            for (WxOrder order : orders1) {
                if (order.getOrderStatus() == 301) {
                    orders.add(order);
                }
            }
        }else if(showType==4) {
            for (WxOrder order : orders1) {
                if (order.getOrderStatus()==401) {
                    orders.add(order);
                }
            }
        }
        //PageInfo<WxOrder> wxOrderPageInfo = new PageInfo<>(orders);
        ResponseVO<Map<Object,Object>> responseVO = new ResponseVO<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("data",orders);
        map.put("totalPages",orders.size()/10);
        map.put("count",orders.size());
        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }


    @RequestMapping("wx/order/detail")
    @ResponseBody
    public ResponseVO<WxOrderDetail> orderDetail(Integer orderId){
        WxOrderDetail orderDetail = wxOrderService.queryDetailByOid(orderId);
        if(orderDetail.getOrderInfo().getOrderStatus()==101){
            orderDetail.getOrderInfo().setOrderStatusText("待支付");
        }else if(orderDetail.getOrderInfo().getOrderStatus()==201){
            orderDetail.getOrderInfo().setOrderStatusText("已付款");
        }else if(orderDetail.getOrderInfo().getOrderStatus()==301){
            orderDetail.getOrderInfo().setOrderStatusText("已发货");
        }else if(orderDetail.getOrderInfo().getOrderStatus()==401){
            orderDetail.getOrderInfo().setOrderStatusText("已收货");
        }

        ResponseVO<WxOrderDetail> responseVO = new ResponseVO<>();
        responseVO.setData(orderDetail);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping("wx/order/prepay")
    @ResponseBody
    public ResponseVO<Object> orderPrepay(){
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setErrmsg("订单不能支付");
        responseVO.setErrno(724);
        return responseVO;
    }

    @RequestMapping("wx/order/refund")
    @ResponseBody
    public ResponseVO<Object> orderRefund(@RequestBody Map Orders){
        Integer OrderId = (Integer)Orders.get("orderId");
        int i = wxOrderService.changeOrderStatus(202, OrderId);
        if(i>0){
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;}
        return null;
    }

    @RequestMapping("wx/order/confirm")
    @ResponseBody
    public ResponseVO<Object> orderConfirm(@RequestBody Map Orders){
        Integer OrderId = (Integer)Orders.get("orderId");
        int i = wxOrderService.changeOrderStatus(401, OrderId);
        if(i>0){
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;}
        return null;
    }

    @RequestMapping("wx/order/cancel")
    @ResponseBody
    public ResponseVO<Object> orderCancel(@RequestBody Map Orders){
        Integer OrderId = (Integer)Orders.get("orderId");
        int i = wxOrderService.changeOrderStatus(102, OrderId);
        if(i>0){
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;}
        return null;
    }

    @RequestMapping("wx/order/delete")
    @ResponseBody
    public ResponseVO<Object> orderDelete(@RequestBody Map Orders){
        Integer OrderId = (Integer)Orders.get("orderId");
        int i = wxOrderService.deleteOrder(OrderId);
        if(i>0){
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;}
        return null;
    }


    @RequestMapping("wx/order/goods")
    @ResponseBody
    public ResponseVO<Object> orderGoods(Integer orderId,Integer goodsId){
        OrderGoods orderGoods = wxOrderService.queryOGByOidAndGid(orderId, goodsId);
        if(orderGoods!=null){
            ResponseVO<Object> responseVO = new ResponseVO<>();
            responseVO.setData(orderGoods);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;}
        return null;
    }

//    @RequestMapping("wx/order/comment")
//    @ResponseBody
//    public ResponseVO<Object> orderComment(Integer orderId,Integer goodsId){
//        OrderGoods orderGoods = wxOrderService.queryOGByOidAndGid(orderId, goodsId);
//        if(orderGoods!=null){
//            ResponseVO<Object> responseVO = new ResponseVO<>();
//            responseVO.setData(orderGoods);
//            responseVO.setErrmsg("成功");
//            responseVO.setErrno(0);
//            return responseVO;}
//        return null;
//    }
}
