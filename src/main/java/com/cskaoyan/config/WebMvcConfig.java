package com.cskaoyan.config;

import com.cskaoyan.converter.MapToQueryMapVOConverter;
import com.cskaoyan.converter.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    StringToDateConverter stringToDateConverter;

    @Autowired
    MapToQueryMapVOConverter mapToQueryMapVOConverter;  //Map转换为QueryMap

    @Autowired
    ConfigurableConversionService conversionService;

    @PostConstruct
    public void addConverter(){
        conversionService.addConverter(new StringToDateConverter());
        conversionService.addConverter(mapToQueryMapVOConverter);
    }

    @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService(){
        return conversionService;
    }
}
