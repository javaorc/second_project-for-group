package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.Storage;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/3 17:07
 **/
public interface AdService {
    List<Ad> findAdList(String name,String content);

    int updateAd(Ad ad);

    int deleteAd(Ad ad);

    int insertStorage(Storage storage);

    int queryStorageIdByKey(String key);

    int insertAd(Ad ad);
}
