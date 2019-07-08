package com.cskaoyan.service.userManegeService;


import com.cskaoyan.bean.Address;
import com.cskaoyan.mapper.userManege.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> queryAddress() {
        List<Address> addresses = addressMapper.queryAddress();
        return addresses;
    }

    @Override
    public List<Address> queryAddressByUserId(Integer userId) {
        List<Address> addresses = addressMapper.queryAddressByUserId(userId);
        return addresses;

    }

    @Override
    public List<Address> queryAddressByName(String name) {
        List<Address> addresses = addressMapper.queryAddressByName(name);
        return addresses;
    }

    @Override
    public List<Address> queryAddressByUserIdAndName(Integer userId, String name) {
        List<Address> addresses = addressMapper.queryAddressByUserIdAndName(userId, name);
        return addresses;
    }
}
