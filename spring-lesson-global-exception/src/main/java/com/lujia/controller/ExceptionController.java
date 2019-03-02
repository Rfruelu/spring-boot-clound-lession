package com.lujia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/11/27  10:01
 */
@RestController
public class ExceptionController {

    @RequestMapping("/exception")
    public String exception(){
        int a=1;
        int b=0;

        return a/b+"";

    }
}
