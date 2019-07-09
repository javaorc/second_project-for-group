package com.cskaoyan.mapper;

import com.cskaoyan.bean.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCarMapper {
    void cartAdd(Cart cart);

    Cart cartGet(Cart cart);

}
