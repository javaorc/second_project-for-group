package com.cskaoyan.mapper.generalize;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.bean.wxBean.WxBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/3 17:15
 **/
public interface AdMapper {
    List<Ad> findAdList(@Param("name") String name,@Param("content") String content);

    int updateAd(@Param("ad") Ad ad);

    int deleteAd(@Param("ad") Ad ad);

    int insertStorage(@Param("sto") Storage storage);

    int queryStorageIdByKey(@Param("key") String key);

    int insertAd(@Param("ad") Ad ad);

    List<WxBanner> queryAds();
}
