package com.example.lujia.web;


import com.example.lujia.feignClient.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/6/24.
 */
@RestController
//@RequestMapping("/api-feign")
public class HiController {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = "/hello")
    public String sayHi(@RequestParam String name){
        return helloClient.hello(name);
    }
}
