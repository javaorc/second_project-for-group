package com.cskaoyan.service.wxAddress;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.wxBean.WxAddress;
import com.cskaoyan.bean.wxBean.WxAddress2;

import java.util.List;

public interface WxAddressService {
    List<WxAddress> queryAddressListByUserId(int userId);

    WxAddress2 queryAddressById(int id);

    int saveAddress(Address address, Integer userId);

    int updateAddress(Address address);

    int insertAddress(Address address);

    int deleteAddressById(int id);


}
