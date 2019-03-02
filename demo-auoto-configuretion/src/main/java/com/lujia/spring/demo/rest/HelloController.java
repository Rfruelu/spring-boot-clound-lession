package com.lujia.spring.demo.rest;

import com.lujia.spring.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author :lujia
 * @date :2018/12/18  16:24
 */
@RestController

public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String sayHello(){
        return helloService.sayHello();
    }
}
