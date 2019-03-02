package com.lujia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author :lujia
 * @date :2018/11/20  11:28
 */
@Configuration
public class SessionInterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
