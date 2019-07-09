package com.cskaoyan.service;

import com.cskaoyan.bean.Cart;
import com.cskaoyan.mapper.ShoppingCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService{
@Autowired
ShoppingCarMapper shoppingCarMapper;
    @Override
    public void cartAdd(Cart cart) {
        shoppingCarMapper.cartAdd(cart);
    }

    @Override
    public Cart cartGet(Cart cart) {
        return shoppingCarMapper.cartGet(cart);
    }
}
