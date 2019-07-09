package com.cskaoyan.service.wxLoginAndRegister;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.wxLoginAndRegister.WxLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxLoginServiceImpl implements WxLoginService {
    @Autowired(required = false)
    WxLoginMapper wxLoginMapper;
    @Override
    public User isUser(User user) {
        User user1 = wxLoginMapper.isUser(user);
        return user1;
    }

    @Override
    public List<Order> queryOrderByUid(Integer userId) {
        return wxLoginMapper.queryOrderByUid(userId);
    }
}
