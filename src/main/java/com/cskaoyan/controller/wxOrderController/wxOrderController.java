package com.cskaoyan.controller.wxOrderController;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxCommentBackInfo;
import com.cskaoyan.bean.wxBean.WxOrder;
import com.cskaoyan.bean.wxBean.WxOrderDetail;
import com.cskaoyan.bean.wxBean.WxSubmitInfo;
import com.cskaoyan.mapper.wxOrder.WxOrderMapper;
import com.cskaoyan.oss.MyOssClient;
import com.cskaoyan.service.MallOrderService;
import com.cskaoyan.service.generalize.AdService;
import com.cskaoyan.service.wxLoginAndRegister.WxLoginService;
import com.cskaoyan.service.wxOrder.WxOrderService;
import com.cskaoyan.tokenManager.UserTokenManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class wxOrderController {
    @Autowired
    WxLoginService wxLoginService;
    @Autowired
    WxOrderService wxOrderService;
    @Autowired
    MyOssClient myOssClient;
    @Autowired
    AdService adService;
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
    public ResponseVO<Object> orderPrepay(@RequestBody Map Orders){


        String s = (String) Orders.get("orderId");
        s.replaceAll("\"","");
        Integer OrderId = Integer.parseInt(s);
        int i = wxOrderService.changeOrderStatus(201, OrderId);
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

    @RequestMapping("wx/order/comment")
    @ResponseBody
    public ResponseVO<Object> orderComment(@RequestBody WxCommentBackInfo comment,HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        OrderGoods orderGoods = wxOrderService.queryOGById(comment.getOrderGoodsId());
        orderGoods.setComment(orderGoods.getComment() + 1);
        int i = wxOrderService.updateComment(orderGoods);
        int temp = 0;
        int newComment = wxOrderService.createNewComment(orderGoods, userId, temp, comment.getStar(), comment.getContent());
        if (newComment > 0&&i>0) {
            ResponseVO<Object> responseVO = new ResponseVO<>();
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }


    @RequestMapping("wx/storage/upload")
    @ResponseBody
    public ResponseVO<Object> storageUpload(MultipartFile file) throws IOException {
        String url = myOssClient.ossFileUpload(file);
        Storage storage = new Storage();
        Date date = new Date();
        storage.setName(file.getOriginalFilename());
        storage.setAddTime(date);
        storage.setUpdateTime(date);

        String[] split = url.split("/");
        String key = split[split.length-1] + ".png";
        storage.setKey(key);

        storage.setSize((int) file.getSize());
        storage.setUrl(url);
        storage.setType(file.getContentType());
        storage.setDeleted(false);
        int i = adService.insertStorage(storage);
        if (i == 1) {
            //通过key 查找出id ，将id赋值给storage
            int id = adService.queryStorageIdByKey(key);
            storage.setId(id);
            ResponseVO<Object> responseVO = new ResponseVO<>();
            responseVO.setData(storage);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        return null;
    }

    @RequestMapping("wx/order/submit")
    @ResponseBody
    public ResponseVO<Object> orderSubmit(@RequestBody WxSubmitInfo wxSubmitInfo,HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        Address address = wxOrderService.queryAddressByAid(wxSubmitInfo.getAddressId());
        ResponseVO<Object> responseVO = new ResponseVO<>();
        if(wxSubmitInfo.getCartId()!=0){
            Cart cart = wxOrderService.queryCartByCid(wxSubmitInfo.getCartId());
            Short s = 1;
            short s2 = 101;
            Order order = new Order(userId, null, "",
                    s2, "1", address.getMobile(),
                    address.getAddress(), address.getAddress(), new BigDecimal(cart.getGoods().getRetailPrice()),
                    cart.getPrice(), cart.getPrice(),
                    new BigDecimal(cart.getGoods().getCounterPrice()), new BigDecimal(0),
                    new BigDecimal(cart.getGoods().getRetailPrice()), new BigDecimal(cart.getGoods().getRetailPrice()),
                    "0", new Date(), "abcd",
                    "1", new Date(), null,
                    s, new Date(), new Date(), new Date(),
                    false);
            int i = wxOrderService.insertOrder(order);
            responseVO.setData(order.getId());
        }else {
            List<Cart> carts = wxOrderService.queryCartByChecked();
            for (Cart cart : carts) {
                Short s = 1;
                short s2 = 101;
                Order order = new Order(userId, null, "",
                        s2, "1", address.getMobile(),
                        address.getAddress(), address.getAddress(), new BigDecimal(cart.getGoods().getRetailPrice()),
                        cart.getPrice(), cart.getPrice(),
                        new BigDecimal(cart.getGoods().getCounterPrice()), new BigDecimal(0),
                        new BigDecimal(cart.getGoods().getRetailPrice()), new BigDecimal(cart.getGoods().getRetailPrice()),
                        "0", new Date(), "abcd",
                        "1", new Date(), null,
                        s, new Date(), new Date(), new Date(),
                        false);
                int i = wxOrderService.insertOrder(order);

                OrderGoods orderGoods = new OrderGoods(order.getId(), null, cart.getGoods().getId(),
                        null, cart.getGoods().getName(), cart.getGoods().getGoodsSn(), cart.getProductId(),
                        cart.getGoodsProduct(), s, new BigDecimal(cart.getGoodsProduct().getPrice()),
                        cart.getGoodsProduct().getSpecifications().toString(), cart.getGoodsProduct().getUrl(), 0,
                        new Date(), new Date(), false);
                int j = wxOrderService.insertOrderGoods(orderGoods);
                responseVO.setData(order.getId());
            }

            }
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;

    }

}
