package com.cskaoyan.mapper.userManege;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> queryUserByUsernameAndMobile(@Param("username")String username,@Param("mobile")String mobile);
    List<User> queryUser();
    User queryUserById(@Param("id")Integer id);
}
