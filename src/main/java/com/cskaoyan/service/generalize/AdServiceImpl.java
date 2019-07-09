package com.cskaoyan.service.generalize;

import com.cskaoyan.bean.Ad;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxBanner;
import com.cskaoyan.mapper.generalize.AdMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/3 17:08
 **/
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdMapper adMapper;

    ResponseVO<Map<String, Object>> mapResponseVO = new ResponseVO<>();

    Map<String, Object> map = new HashMap<>();


    @Override
    public ResponseVO<Map<String, Object>> findAdList(String name, String content, int page, int limit) {
        if ("".equals(name)) {
            name = null;
        }
        if ("".equals(content)) {
            content = null;
        }
        List<Ad> adList = adMapper.findAdList(name, content);
        //分页
        PageHelper.startPage(page, limit);
        PageInfo<Ad> adPageInfo = new PageInfo<>(adList);
        //封装
        map.put("total", adPageInfo.getTotal());
        map.put("items", adList);
        mapResponseVO.setData(map);
        mapResponseVO.setErrmsg("成功");
        mapResponseVO.setErrno(0);
        return mapResponseVO;
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

    @Override
    public List<WxBanner> queryAds() {
        return adMapper.queryAds();
    }
}
