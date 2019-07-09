package com.cskaoyan.mapper;

import com.cskaoyan.bean.Cart;

public interface ShoppingCarMapper {
    void cartAdd(Cart cart);

    Cart cartGet(Cart cart);

}
