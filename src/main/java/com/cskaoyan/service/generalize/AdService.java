package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxBanner;

import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/3 17:07
 **/
public interface AdService {
    ResponseVO<Map<String, Object>> findAdList(String name, String content, int page, int limit);

    int updateAd(Ad ad);

    int deleteAd(Ad ad);

    int insertStorage(Storage storage);

    int queryStorageIdByKey(String key);

    int insertAd(Ad ad);

    List<WxBanner> queryAds();
}
