package com.cskaoyan.mapper.system;

import com.cskaoyan.bean.System;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface SystemMapper {
    //键值对映射
    List<System> querySystem();

    int updateSystem(@Param("s1") System system,@Param("s2") System system1);

    List<System> selectByMail();

    List<System> selectByOrder();


    List<System> selectByExpree();

    List<System> selectByWx();

    System selectByKeyName(@Param("key") String key);


}
