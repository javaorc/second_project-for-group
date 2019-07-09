package com.cskaoyan.mapper.wxCollectZLX;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxCollectZLXMapper {

    List<Collect> queryCollect(@Param("userId")int userId);
}
