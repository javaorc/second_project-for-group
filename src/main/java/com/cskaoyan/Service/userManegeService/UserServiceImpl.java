package com.cskaoyan.Service.userManegeService;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.userManege.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryUserByUsernameAndMobile(String username,String mobile) {
        List<User> users = userMapper.queryUserByUsernameAndMobile(username,mobile);
        return users;
    }

    @Override
    public List<User> queryUser() {
        List<User> users = userMapper.queryUser();
        return users;
    }

}
