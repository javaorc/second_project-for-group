package com.cskaoyan.controller;

import com.cskaoyan.bean.Cart;
import com.cskaoyan.bean.LzgOrder;
import com.cskaoyan.service.MallRegionService;
import com.cskaoyan.service.ShoppingCarService;
import com.cskaoyan.tokenManager.UserTokenManager;
import com.cskaoyan.typeHandler.IntArrayToString;
import com.cskaoyan.util.CartUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wx")
public class ShoppingCarController {
    @Autowired
    ShoppingCarService shoppingCarService;
    @Autowired
    MallRegionService mallRegionService;
    @RequestMapping("cart/goodscount")
    @ResponseBody
    public Map cartCount(){
        Map map = new HashMap();
        map.put("data",10);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("cart/add")
    @ResponseBody
    public Map cartAdd(@RequestBody Cart cart, HttpServletRequest httpServletRequest) {
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        int pid=cart.getProductId();
        Cart carts=shoppingCarService.cartsGet(pid,uid);
        if (carts==null){
            Cart cart1=shoppingCarService.cartGet(cart);

            cart1.setNumber(cart.getNumber());
            cart1.setProductId(cart.getProductId());
            cart1.setUserId(uid);
            cart1.setChecked(true);
            cart1.setDeleted(true);
            cart1.setGoodsId(cart.getGoodsId());
            String[] specifications =cart1.getSpecifications();
            String specification = IntArrayToString.stringArrayToString(specifications);
            cart1.setSpecification(specification);
            shoppingCarService.cartAdd(cart1);
            Map map = new HashMap();
            int data=shoppingCarService.itemsCount(uid);
            map.put("data",data+1);
            map.put("errmsg","成功");
            map.put("errno",0);
            return map;
        }else {
            Cart cart1=shoppingCarService.cartGet(cart);
            int number=cart.getNumber()+carts.getNumber();
            cart1.setProductId(cart.getProductId());
            cart1.setUserId(uid);
            cart1.setChecked(true);
            cart1.setDeleted(true);
            cart1.setGoodsId(cart.getGoodsId());
            String[] specifications =cart1.getSpecifications();
            String specification = IntArrayToString.stringArrayToString(specifications);
            cart1.setSpecification(specification);
            cart1.setNumber((short)number);
            shoppingCarService.cartAdd1(cart1);
            Map map = new HashMap();
            int data=shoppingCarService.itemsCount(uid);
            map.put("data",data+1);
            map.put("errmsg","成功");
            map.put("errno",0);
            return map;
        }

    }
    @RequestMapping("cart/checked")
    @ResponseBody
    public Map cartChecked(@RequestBody Map map, HttpServletRequest httpServletRequest){
       List<Integer> productIds1=(List) map.get("productIds");
       int[] productIds=new int[productIds1.size()];
       for (int i=0;i<productIds1.size();i++){
           productIds[i]=productIds1.get(i);
       }
         int isChecked=(int)map.get("isChecked");
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        shoppingCarService.goodsCheck(productIds,isChecked,uid);
        CartUtil cartUtil=new CartUtil();
        Map map1=cartUtil.cartUtil(shoppingCarService,uid);

        return map1;
    }
    @GetMapping("cart/index")
    @ResponseBody
    public Map cartIndex(HttpServletRequest httpServletRequest){
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        CartUtil cartUtil=new CartUtil();
        Map map=cartUtil.cartUtil(shoppingCarService,uid);
        Map map1=new HashMap();map1.put("data",map);

       return map;
    }
    @RequestMapping("cart/delete")
    @ResponseBody
    public Map cartDelete(@RequestBody Map map ,HttpServletRequest httpServletRequest){
        List<Integer> productIds1=(List) map.get("productIds");
        int[] productIds=new int[productIds1.size()];
        for (int i=0;i<productIds1.size();i++){
            productIds[i]=productIds1.get(i);
        }
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);
        shoppingCarService.cartDelete(productIds,uid);
        CartUtil cartUtil=new CartUtil();
        Map map1=cartUtil.cartUtil(shoppingCarService,uid);
        return map1;
    }
    @RequestMapping("cart/checkout")
    @ResponseBody
    public Map cartCheckout(int cartId,int addressId,int couponId,int grouponRulesId,HttpServletRequest httpServletRequest){
        String tokenKey=httpServletRequest.getHeader("X-Litemall-Token");
        Integer uid= UserTokenManager.getUserId(tokenKey);

       LzgOrder order= shoppingCarService.cartCheckout(uid,addressId,couponId,grouponRulesId);
       order.setAddressId(addressId);
       order.setGrouponRulesId(grouponRulesId);
       order.setCouponId(couponId);
       Map map=new HashMap();
       map.put("data",order);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("cart/fastadd")
    @ResponseBody
    public Map cartFastadd(int goodsId,int number,int productId){
        Map map=new HashMap();
        map.put("data",186);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
}
