package com.lujia.springWebMVC.springrestwebmvc.config;

import com.lujia.springWebMVC.springrestwebmvc.message.convert.PropertiesHttpMessageConverters;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author :lujia
 * @date :2018/7/22  16:09
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  /*  @Override
    public void  configureMessageConverters(List<HttpMessageConverter<?>> converters) {


        converters.add(new MappingJackson2HttpMessageConverter());
        System.err.println("configureMessageConverters--->converters.size:"+converters.size());
    }
*/
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new PropertiesHttpMessageConverters());

        System.err.println("extendMessageConverters--->converters.size:"+converters.size());
    }
}
