package com.cskaoyan.service;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.Cart;
import com.cskaoyan.bean.LzgOrder;
import com.cskaoyan.mapper.ShoppingCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int itemsCount(Integer uid) {
        return shoppingCarMapper.itemsCount(uid);
    }

    @Override
    public List cartGoodsList(Integer uid) {
     return  shoppingCarMapper.cartGoodsList(uid);
    }

    @Override
    public void goodsCheck(int[] productIds, int isChecked, Integer uid) {
        shoppingCarMapper.goodsCheck(productIds,isChecked,uid);
    }

    @Override
    public void cartDelete(int[] productIds, Integer uid) {
        shoppingCarMapper.cartDelete(productIds,uid);
    }

    @Override
    public LzgOrder cartCheckout(int cartId, int addressId, int couponId, int grouponRulesId) {
        return shoppingCarMapper.cartCheckout(cartId,addressId,couponId,grouponRulesId);
    }

    @Override
    public List<Address> addressList(Integer uid) {
        return shoppingCarMapper.addressList(uid);
    }

    @Override
    public String addressSearch(Integer provinceId) {
        return shoppingCarMapper.addressSearch(provinceId);
    }

    @Override
    public Cart cartsGet(int pid, Integer uid) {
        return shoppingCarMapper.cartsGet(pid,uid);
    }

    @Override
    public void cartAdd1(Cart cart1) {
        shoppingCarMapper.cartAdd1(cart1);
    }

}
