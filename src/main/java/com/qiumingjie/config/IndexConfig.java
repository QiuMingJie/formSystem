package com.qiumingjie.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author QiuMingJie
 * @date 2020-07-21 10:46
 * @description
 */
@Configuration
public  class IndexConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/formSystem/").setViewName("/formSystem/dist/index.html#/");

    }

}
