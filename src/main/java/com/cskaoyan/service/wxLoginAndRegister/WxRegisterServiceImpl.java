package com.cskaoyan.service.wxLoginAndRegister;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.wxLoginAndRegister.WxRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxRegisterServiceImpl implements WxRegisterService {
    @Autowired(required = false)
    WxRegisterMapper wxRegisterMapper;
    @Override
    public Boolean userExist(User user) {
        int i = wxRegisterMapper.userExist(user);
        if(i==0){
            return false;
        }
        return true;
    }

    @Override
    public int createUser(User user) {
        return wxRegisterMapper.createUser(user);
    }
}
