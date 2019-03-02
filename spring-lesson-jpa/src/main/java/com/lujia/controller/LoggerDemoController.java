package com.lujia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :lujia
 * @date :2018/11/20  15:59
 */
@RestController
public class LoggerDemoController {


    @RequestMapping("/logger/demo")
    public Object doWork(@RequestParam("name") String name, HttpServletRequest request){
        Map<String,Object > resultMap=new HashMap<>(3);

        resultMap.put("name",name);
        resultMap.put("age",22);
        request.setAttribute("RETURN_VALUE",resultMap);
        return resultMap;
    }
}
