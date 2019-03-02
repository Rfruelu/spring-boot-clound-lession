package com.lujia.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/11/23  9:08
 */
@RestController
@Slf4j
public class LoggerController {

    @RequestMapping("/logger")
    public String testLogger(){
        //在logback-spring.xml文件中定义了日志记录几笔而是info，debug级别的日志不会记录
        log.debug("----debug--66666-");
        log.info("----info--66666-");

        log.error("----error--66666-");
        return "test logger";
    }
}
