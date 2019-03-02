package springboot.lujia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/11/13  16:31
 */
@RestController
public class PropertiesController {


    @RequestMapping("/book/name")
    public String getBookName(){
        return "";
    }
}
