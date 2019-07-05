package com.cskaoyan.config;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SystemConfig {
    // 运费相关配置
    public final static String CSKAOYAN_EXPRESS_FREIGHT_VALUE = "cskaoyan_express_freight_value";
    public final static String CSKAOYAN_EXPRESS_FREIGHT_MIN = "cskaoyan_express_freight_min";
    // 订单相关配置
    public final static String CSKAOYAN_ORDER_UNPAID = "cskaoyan_order_unpaid";
    public final static String CSKAOYAN_ORDER_UNCONFIRM = "cskaoyan_order_unconfirm";
    public final static String CSKAOYAN_ORDER_COMMENT = "cskaoyan_order_comment";
    // 商场相关配置
    public final static String CSKAOYAN_MALL_NAME = "cskaoyan_mall_name";
    public final static String CSKAOYAN_MALL_ADDRESS = "cskaoyan_mall_address";
    public final static String CSKAOYAN_MALL_PHONE = "cskaoyan_mall_phone";
    public final static String CSKAOYAN_MALL_QQ = "cskaoyan_mall_qq";


    //所有的配置均保存在该 HashMap 中
    private static Map<String, String> SYSTEM_CONFIGS = new HashMap<>();


    private static String getConfig(String keyName) {
        return SYSTEM_CONFIGS.get(keyName);
    }

    private static Integer getConfigInt(String keyName) {
        return Integer.parseInt(SYSTEM_CONFIGS.get(keyName));
    }

    private static Boolean getConfigBoolean(String keyName) {
        return Boolean.valueOf(SYSTEM_CONFIGS.get(keyName));
    }

    private static BigDecimal getConfigBigDec(String keyName) {
        return new BigDecimal(SYSTEM_CONFIGS.get(keyName));
    }


    public static BigDecimal getFreight() {
        return getConfigBigDec(CSKAOYAN_EXPRESS_FREIGHT_VALUE);
    }

    public static BigDecimal getFreightLimit() {
        return getConfigBigDec(CSKAOYAN_EXPRESS_FREIGHT_MIN);
    }

    public static Integer getOrderUnpaid() {
        return getConfigInt(CSKAOYAN_ORDER_UNPAID);
    }

    public static Integer getOrderUnconfirm() {
        return getConfigInt(CSKAOYAN_ORDER_UNCONFIRM);
    }

    public static Integer getOrderComment() {
        return getConfigInt(CSKAOYAN_ORDER_COMMENT);
    }

    public static String getMallName() {
        return getConfig(CSKAOYAN_MALL_NAME);
    }

    public static String getMallAddress() {
        return getConfig(CSKAOYAN_MALL_ADDRESS);
    }

    public static String getMallPhone() {
        return getConfig(CSKAOYAN_MALL_PHONE);
    }

    public static String getMallQQ() {
        return getConfig(CSKAOYAN_MALL_QQ);
    }

    public static void setConfigs(Map<String, String> configs) {
        SYSTEM_CONFIGS = configs;
    }

    public static void updateConfigs(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            SYSTEM_CONFIGS.put(entry.getKey(), entry.getValue());
        }
    }
}

