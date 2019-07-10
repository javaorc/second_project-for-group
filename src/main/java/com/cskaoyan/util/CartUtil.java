package com.cskaoyan.util;

import com.cskaoyan.bean.Cart;
import com.cskaoyan.service.ShoppingCarService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartUtil {
    int checkedGoodsAmount=0;
    int checkedGoodsCount=0;
    int goodsAmount=0;
    int goodsCount=0;

    public Map cartUtil( ShoppingCarService shoppingCarService,int uid){
        List<Cart> list=shoppingCarService.cartGoodsList(uid);
        for(Cart cart:list){
            goodsCount+=cart.getNumber();
            goodsAmount+=(Double.parseDouble(String.valueOf(cart.getPrice()))* cart.getNumber());
            if (cart.getChecked()==true){
                checkedGoodsCount +=cart.getNumber();
                checkedGoodsAmount+=(Double.parseDouble(String.valueOf(cart.getPrice()))* cart.getNumber());
            }
        }
        Map map1=new HashMap();
        map1.put("checkedGoodsAmount",checkedGoodsAmount);
        map1.put("checkedGoodsCount",checkedGoodsCount);
        map1.put("goodsAmount",goodsAmount);
        map1.put("goodsCount",goodsCount);
        Map map = new HashMap();
        map.put("cartList",list);
        map.put("cartTotal",map1);
     /*   */
        Map map2=new HashMap();
        map2.put("data",map);
        map2.put("errmsg","成功");
        map2.put("errno",0);
        return map2;
    }

}
