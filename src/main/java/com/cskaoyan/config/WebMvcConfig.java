package com.cskaoyan.config;

import com.cskaoyan.converter.MapToQueryMapVOConverter;
import com.cskaoyan.converter.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    ConfigurableConversionService conversionService;

    @Autowired
    StringToDateConverter stringToDateConverter;

    @Autowired
    MapToQueryMapVOConverter mapToQueryMapVOConverter;

    public void addConverter(){
        conversionService.addConverter(stringToDateConverter);
        conversionService.addConverter(mapToQueryMapVOConverter);
    }
}
