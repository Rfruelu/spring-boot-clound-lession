package com.lujia.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :lujia
 * @date :2018/11/15  17:09
 */
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String index(){

        return "index";
    }

}
