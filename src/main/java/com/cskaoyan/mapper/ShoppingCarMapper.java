package com.cskaoyan.mapper;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.Cart;
import com.cskaoyan.bean.LzgOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCarMapper {
    void cartAdd(Cart cart);

    Cart cartGet(Cart cart);

    int itemsCount(Integer uid);

    List cartGoodsList(Integer uid);

    void goodsCheck(@Param("productIds") int[] productIds, @Param("isChecked")int isChecked, @Param("uid") int uid);

    void cartDelete(@Param("productIds")int[] productIds, @Param("uid")int uid);

    LzgOrder cartCheckout(@Param("cartId") int cartId, @Param("addressId")int addressId, @Param("couponId")int couponId, @Param("grouponRulesId") int grouponRulesId);

    List<Address> addressList(int uid);

    String addressSearch(Integer provinceId);
}
