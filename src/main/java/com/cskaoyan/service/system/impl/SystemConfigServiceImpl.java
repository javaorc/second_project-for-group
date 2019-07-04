package com.cskaoyan.service.system.impl;

import com.cskaoyan.bean.System;
import com.cskaoyan.mapper.system.SystemConfigMapper;
import com.cskaoyan.service.system.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    SystemConfigMapper mapper;

    @Override
    public Map<String, Object> listExpress() {
        List<System> systemList = mapper.selectByExpree();
        Map<String, Object> data = new HashMap<>();
        for(System system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    @Override
    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
//            LitemallSystemExample example = new LitemallSystemExample();
//            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);
//            System example = mapper.selectByKeyName(entry.getKey());
//            System system = new System();
//            system.setKeyName(entry.getKey());
//            system.setKeyValue(entry.getValue());
//            system.setUpdateTime(new Date());
//            mapper.updateSystem(system, example);
            System system = mapper.selectByKeyName(entry.getKey());
            System system1 = new System();
            system1.setKeyName(entry.getKey());
            system1.setKeyValue(entry.getValue());
            system1.setUpdateTime(new Date());
            mapper.updateSystem(system1,system);


        }
    }

    @Override
    public Map<String, Object> listOrder() {
        List<System> systemList = mapper.selectByOrder();
        Map<String, Object> data = new HashMap<>();
        for(System system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    @Override
    public Map<String, Object> listMail() {
        List<System> systemList = mapper.selectByMail();
        Map<String, Object> data = new HashMap<>();
        for(System system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

/*
    @Override
    public Map<String, Object> queryAll() {
        List<System> systemList = mapper.querySystem();
        Map<String, Object> systemConfigs = new HashMap<>();
        for (System item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }
*/

    @Override
    public Map<String, Object> listWx() {
        List<System> systemList = mapper.selectByWx();
        Map<String, Object> data = new HashMap<>();
        for(System system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }
}
