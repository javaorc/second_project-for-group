package com.cskaoyan.service.wxAddress;

import com.cskaoyan.bean.wxBean.WxAddress;
import com.cskaoyan.bean.wxBean.WxAddress2;
import com.cskaoyan.mapper.wxAddress.WxAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int updateAddress(WxAddress2 address, int uid) {
        if (address.getIsDefault()) {
            addressMapper.clearDefaultAddress(uid);
        }
        return addressMapper.updateAddress(address);
    }
}
