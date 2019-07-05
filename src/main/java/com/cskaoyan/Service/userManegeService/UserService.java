package com.cskaoyan.Service.userManegeService;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.User;

import java.util.List;

public interface UserService {

    List<User> queryUserByUsernameAndMobile(String username,String mobile);
    List<User> queryUser();

}
