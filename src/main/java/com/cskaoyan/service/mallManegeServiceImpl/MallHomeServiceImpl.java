package com.cskaoyan.service.mallManegeServiceImpl;

import com.cskaoyan.bean.HomeData;
import com.cskaoyan.mapper.mallManege.MallHomeMapper;
import com.cskaoyan.service.MallHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MallHomeServiceImpl implements MallHomeService {
    @Autowired(required = false)
    MallHomeMapper mallHomeMapper;
    @Override
    public HomeData showHome() {
        return mallHomeMapper.showHome();
    }
}
