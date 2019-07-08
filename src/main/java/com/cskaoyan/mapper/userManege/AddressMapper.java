package com.cskaoyan.mapper.userManege;

import com.cskaoyan.bean.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    List<Address> queryAddress();

    List<Address> queryAddressByUserId(@Param("userId")Integer userId);

    List<Address> queryAddressByName(@Param("name")String name);

    List<Address> queryAddressByUserIdAndName(@Param("userId")Integer userId,@Param("name")String name);
}
