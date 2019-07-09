package com.cskaoyan.controller;

import com.cskaoyan.bean.Cart;
import com.cskaoyan.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("wx")
public class ShoppingCarController {
    @Autowired
    ShoppingCarService shoppingCarService;
    @RequestMapping("cart/add")
    public Map cartAdd(@RequestBody Cart cart, HttpServletRequest httpServletRequest) {
        Cart cart1=shoppingCarService.cartGet(cart);


        shoppingCarService.cartAdd(cart1);
        Map map = new HashMap();
        map.put("data",8);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }


/*@RequestMapping("cart/checked")
@RequestMapping("cart/checkout")

@RequestMapping("cart/delete")
@RequestMapping("cart/index")
@RequestMapping("address/list")
@RequestMapping("address/delete")
@RequestMapping("coupon/selectlist")
@RequestMapping("order/submit")
@RequestMapping("order/prepay")*/

}
