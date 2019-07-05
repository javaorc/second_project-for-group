package com.cskaoyan.service.system;



import com.cskaoyan.bean.System;

import java.util.Map;

public interface SystemConfigService {

    Map<String, Object> listExpress();

    void updateConfig(Map<String, String> data);

    Map<String, Object> listOrder();

    Map<String, Object> listMail();

    Map<String, Object> listWx();



}
