package com.cskaoyan.controller;

import com.cskaoyan.bean.Cart;
import com.cskaoyan.bean.LzgOrder;
import com.cskaoyan.bean.Order;
import com.cskaoyan.service.ShoppingCarService;
import com.cskaoyan.tokenManager.UserTokenManager;
import com.cskaoyan.util.CartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("wx")
public class ShoppingCarController {
    @Autowired
    ShoppingCarService shoppingCarService;
    @RequestMapping("cart/goodscount")
    @ResponseBody
    public Map cartCount(){
        Map map = new HashMap();
        map.put("data",1);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("cart/add")
    public Map cartAdd(@RequestBody Cart cart, HttpServletRequest httpServletRequest) {
        Cart cart1=shoppingCarService.cartGet(cart);
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        cart1.setUserId(uid);
        cart1.setChecked(true);
        cart1.setDeleted(true);
        cart1.setGoodsId(cart.getGoodsId());
        cart1.setProductId(cart.getProductId());
        shoppingCarService.cartAdd(cart1);
        Map map = new HashMap();
        int data=shoppingCarService.itemsCount(uid);
        map.put("data",data+1);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("cart/checked")
    public Map cartChecked(@RequestBody Map map, HttpServletRequest httpServletRequest){
       int[] productIds=(int[]) map.get("productIds");
       int isChecked=(int)map.get("isChecked");
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        shoppingCarService.goodsCheck(productIds,isChecked,uid);
        CartUtil cartUtil=new CartUtil();
        Map map1=cartUtil.cartUtil(shoppingCarService,uid);
        return map1;
    }
    @GetMapping("cart/index")
    public Map cartIndex(HttpServletRequest httpServletRequest){
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        CartUtil cartUtil=new CartUtil();
        Map map=cartUtil.cartUtil(shoppingCarService,uid);
       return map;
    }
    @RequestMapping("cart/delete")
    public Map cartDelete(@RequestBody Map map ,HttpServletRequest httpServletRequest){
        int[] productIds=(int[]) map.get("productIds");
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        shoppingCarService.cartDelete(productIds,uid);
        CartUtil cartUtil=new CartUtil();
        Map map1=cartUtil.cartUtil(shoppingCarService,uid);
        return map1;
    }
    @RequestMapping("cart/checkout")
    public Map cartCheckout(int cartId,int addressId,int couponId,int grouponRulesId){
       LzgOrder order= shoppingCarService.cartCheckout(cartId,addressId,couponId,grouponRulesId);
       order.setAddressId(addressId);
       order.setGrouponRulesId(grouponRulesId);
       order.setCouponId(couponId);
       Map map=new HashMap();
       map.put("data",order);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

/*

 @RequestMapping("address/list")



@
@RequestMapping("coupon/selectlist")
@RequestMapping("order/submit")
@RequestMapping("order/prepay")*/

}
