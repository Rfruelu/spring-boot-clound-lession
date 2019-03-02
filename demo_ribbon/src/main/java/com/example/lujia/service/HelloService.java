package com.example.lujia.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/6/24.
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "error")
    public String helloService(String name){
        return restTemplate.getForObject("http://LUJIA-HELLO/hello?name="+name,String.class);
    }

    public String error(String name){
        return "sorry"+name+" eror!";
    }
}
