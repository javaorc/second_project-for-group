package com.cskaoyan.service;

import com.cskaoyan.bean.Cart;

public interface ShoppingCarService {

    void cartAdd(Cart cart);

    Cart cartGet(Cart cart);
}
