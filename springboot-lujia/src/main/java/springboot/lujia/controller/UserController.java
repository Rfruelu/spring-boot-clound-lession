package springboot.lujia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.lujia.config.BookConfig;
import springboot.lujia.config.UserConfig;

/**
 * @author :lujia
 * @date :2018/11/13  15:27
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserConfig userConfig;

    @Autowired
    private BookConfig bookConfig;
    @RequestMapping("/getName/{name}")
    public String getUserName(@PathVariable("name") String name ){
        return String.format("user name %s",name);
    }

    @RequestMapping("/getUser")
    public String getUserFromProperties(){
        return String.format("user name %s ,user age %s",userConfig.getFullName(),userConfig.getAge());
    }

    @RequestMapping("/book")
    public String getBook(){
        return String.format("book name %s ",bookConfig.getName());
    }
}
