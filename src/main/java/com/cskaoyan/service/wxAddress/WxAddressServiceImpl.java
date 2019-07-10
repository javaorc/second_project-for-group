package com.cskaoyan.service.wxAddress;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.wxBean.WxAddress;
import com.cskaoyan.bean.wxBean.WxAddress2;
import com.cskaoyan.mapper.wxAddress.WxAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WxAddressServiceImpl implements WxAddressService {

    @Autowired
    WxAddressMapper addressMapper;

    @Override
    public List<WxAddress> queryAddressListByUserId(int userId) {
        return addressMapper.queryAddressListByUserId(userId);
    }

    @Override
    public WxAddress2 queryAddressById(int id) {
        return addressMapper.queryAddressById(id);
    }

    @Override
    public int saveAddress(Address address, Integer userId) {

        if (address.getIsDefault()) {
            addressMapper.clearDefaultAddress(userId);
        }

        Date date = new Date();
        address.setUpdateTime(date);

        if (address.getId() == 0) {
            address.setUserId(userId);
            address.setAddTime(date);
            address.setDeleted(false);
            return insertAddress(address);
        } else {
            return updateAddress(address);
        }
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public int insertAddress(Address address) {
        return addressMapper.insertAddress(address);
    }


    @Override
    public int deleteAddressById(int id) {
        return addressMapper.deleteAddressById(id);
    }
}
