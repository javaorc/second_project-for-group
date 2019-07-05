package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.mapper.generalize.AdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/3 17:08
 **/
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdMapper adMapper;
    @Override
    public List<Ad> findAdList(String name,String context) {
        return adMapper.findAdList(name,context);
    }

    @Override
    public int updateAd(Ad ad) {
        return adMapper.updateAd(ad);
    }

    @Override
    public int deleteAd(Ad ad) {
        return adMapper.deleteAd(ad);
    }

    @Override
    public int insertStorage(Storage storage) {
        return adMapper.insertStorage(storage);
    }

    @Override
    public int queryStorageIdByKey(String key) {
        return adMapper.queryStorageIdByKey(key);
    }

    @Override
    public int insertAd(Ad ad) {
        return adMapper.insertAd(ad);
    }


}
