package com.cskaoyan.service.wxLoginAndRegister;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxLoginService {
     User isUser( User user);

     List<Order> queryOrderByUid(Integer UserId);
}
