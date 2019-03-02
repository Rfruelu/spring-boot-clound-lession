package com.example.lujia.controller;

import com.example.lujia.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/6/24.
 */
@RestController
//@RequestMapping("/api-ribbon")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return helloService.helloService(name);
    }
}
