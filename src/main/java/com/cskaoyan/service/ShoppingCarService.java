package com.cskaoyan.service;

import com.cskaoyan.bean.Cart;
import com.cskaoyan.bean.LzgOrder;

import java.util.List;

public interface ShoppingCarService {

    void cartAdd(Cart cart);

    Cart cartGet(Cart cart);

    int itemsCount(Integer uid);

    List cartGoodsList(Integer uid);

    void goodsCheck(int[] productIds, int isChecked, Integer uid);

    void cartDelete(int[] productIds, Integer uid);

    LzgOrder cartCheckout(int cartId, int addressId, int couponId, int grouponRulesId);
}
