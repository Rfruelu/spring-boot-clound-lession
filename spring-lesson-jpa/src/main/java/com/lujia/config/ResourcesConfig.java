package com.lujia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author :lujia
 * @date :2018/11/22  14:39
 */
@Configuration
public class ResourcesConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/lujia/resources/**").addResourceLocations("classpath:/static/");
    }
}
