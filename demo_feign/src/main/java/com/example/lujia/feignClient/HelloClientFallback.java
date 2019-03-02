package com.example.lujia.feignClient;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/6/24.
 */
@Component
public class HelloClientFallback implements HelloClient {
    @Override
    public String hello(String name) {
        return "sorry " + name + " error";
    }
}
