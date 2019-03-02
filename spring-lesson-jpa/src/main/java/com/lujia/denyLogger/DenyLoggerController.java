package com.lujia.denyLogger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/11/23  9:14
 */
@RestController
@Slf4j
public class DenyLoggerController {

    @RequestMapping("/denyLogger")
    public String denyLogger(){
        log.info("----info--denyLogger");
        log.error("----error--denyLogger");
        return "denyLogger";
    }
}
