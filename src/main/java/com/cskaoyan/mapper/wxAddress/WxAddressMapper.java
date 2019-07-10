package com.cskaoyan.mapper.wxAddress;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.wxBean.WxAddress;
import com.cskaoyan.bean.wxBean.WxAddress2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxAddressMapper {

    List<WxAddress> queryAddressListByUserId(@Param("uid") int uid);

    WxAddress2 queryAddressById(@Param("addressId") int id);

    int updateAddress(@Param("address") Address address);

    int insertAddress(@Param("address") Address address);

    void clearDefaultAddress(@Param("uid") int id);

    int deleteAddressById(@Param("id") int id);
}
