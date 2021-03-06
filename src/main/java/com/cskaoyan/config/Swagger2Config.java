package com.cskaoyan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Desc
 * @Author xushuai
 * @CreateTime 2019/7/9 17:00
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //配置api文档的扫描包
                .apis(RequestHandlerSelectors.basePackage("com.cskaoyan.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //关于项目的描述
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .version("1.0SNAPSHOT")
                .title("mall商城")
                .description("这是mall商城项目的描述")
                .contact("com.cskaoyan")
                .build();
    }
}