package com.cskaoyan.service.userManegeService;

import com.cskaoyan.bean.User;

import java.util.List;

public interface UserService {

    List<User> queryUserByUsernameAndMobile(String username,String mobile);
    List<User> queryUserByUsername(String username);
    List<User> queryUserByMoblie(String mobile);
    List<User> queryUser();

}
