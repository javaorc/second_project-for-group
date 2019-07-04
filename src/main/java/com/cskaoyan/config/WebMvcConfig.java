package com.cskaoyan.config;

import com.cskaoyan.converter.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    StringToDateConverter stringToDateConverter;
    @Autowired
    ConfigurableConversionService conversionService;
    public void addConverter(){
        conversionService.addConverter(stringToDateConverter);
    }
}
