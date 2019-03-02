package com.example.lujia.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/6/24.
 */
@FeignClient(value = "lujia-hello",fallback = HelloClientFallback.class)
public interface HelloClient {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
