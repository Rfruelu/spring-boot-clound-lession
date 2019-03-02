package com.example.lujia.web;

import com.example.lujia.domain.Language;
import com.example.lujia.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LuTshoes on 2017/7/18 0018.
 * lutshoes@163.com
 */
@Controller
public class LanguageController {
    private static Logger logger= LoggerFactory.getLogger(LanguageController.class);
    @Autowired
    private LanguageService languageService;

    @Value("${csmbp.version}")
    private String aa;

    @RequestMapping("findById")
    public @ResponseBody Language findById(Long id){
        logger.info("find by id");
        logger.info(aa);
        return new Language();
    }
}
