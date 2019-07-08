package com.cskaoyan.service.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.wxLoginAndRegister.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired(required = false)
    LoginMapper loginMapper;
    @Override
    public User isUser(User user) {
        User user1 = loginMapper.isUser(user);
        return user1;
    }
}
