package springboot.lujia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/11/13  15:07
 */
@RestController
public class HelloWordController {


    @RequestMapping("/")
    public String index(){
        return "index page";
    }

    @RequestMapping("/hello")
    public String say(){
        return "Hello word";
    }
}
