package com.cskaoyan.service.userManegeService;

import com.cskaoyan.bean.Address;

import java.util.List;

public interface AddressService {
    List<Address> queryAddress();
    List<Address> queryAddressByUserId(Integer userId);
    List<Address> queryAddressByName(String name);
    List<Address> queryAddressByUserIdAndName(Integer userId,String name);
}
