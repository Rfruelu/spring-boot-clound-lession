package com.lujia.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :lujia
 * @date :2018/11/16  17:22
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statViewServlet(){
        //创建servlet
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        //允许访问问的ip白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //黑名单，优先于白名单
        servletRegistrationBean.addInitParameter("deny","10.10.10.10");
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        servletRegistrationBean.addInitParameter("restEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.css,*.png,*.ioc,/druid/*");
        return filterRegistrationBean;
    }
}
