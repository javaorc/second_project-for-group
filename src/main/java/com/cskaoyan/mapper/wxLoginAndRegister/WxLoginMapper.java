package com.cskaoyan.mapper.wxLoginAndRegister;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxLoginMapper {
     User isUser(@Param("user")User user);

     List<Order> queryOrderByUid(@Param("uid")Integer UserId);
}
