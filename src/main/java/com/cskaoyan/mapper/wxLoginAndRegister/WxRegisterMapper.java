package com.cskaoyan.mapper.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

public interface WxRegisterMapper {
    int userExist(@Param("user") User user);

    int createUser(@Param("user") User user);
}
