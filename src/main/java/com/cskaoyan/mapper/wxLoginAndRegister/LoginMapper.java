package com.cskaoyan.mapper.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
     User isUser(@Param("user")User user);
}
