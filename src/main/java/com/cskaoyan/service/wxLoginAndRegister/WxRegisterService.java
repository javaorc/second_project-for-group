package com.cskaoyan.service.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

public interface WxRegisterService {
    Boolean userExist( User user);

    int createUser(User user);
}
