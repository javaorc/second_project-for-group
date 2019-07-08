package com.cskaoyan.service.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

public interface LoginService {
     User isUser( User user);
}
