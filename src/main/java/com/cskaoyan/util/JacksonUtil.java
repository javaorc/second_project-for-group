package com.cskaoyan.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.io.IOException;
import java.util.Map;

public class JacksonUtil {

    private static final Log logger = LogFactory.getLog(JacksonUtil.class);
    //map封装工具
    public static Map<String, String> toMap(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(data, new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
