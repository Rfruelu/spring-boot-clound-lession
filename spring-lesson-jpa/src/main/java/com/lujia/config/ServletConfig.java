package com.lujia.config;

import com.lujia.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :lujia
 * @date :2018/11/22  15:38
 */
@Configuration
public class ServletConfig{

    @Bean
    public ServletRegistrationBean testServlet(){
        return new ServletRegistrationBean(new TestServlet(),"/test");
    }
}
