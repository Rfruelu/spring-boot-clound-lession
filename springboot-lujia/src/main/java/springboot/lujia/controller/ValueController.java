package springboot.lujia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :lujia
 * @date :2018/11/14  15:50
 */
@RestController
public class ValueController {


    @Value("${book.name}")
    private String name;

    @Value("${user.fullName}")
    private String fullName;

    @Autowired
    private Environment environment;

    @RequestMapping("/value/book/name")
    public String getBookName(){
        return name;
    }
    @RequestMapping("/value/user/fullName")
    public String getFullName(){
        return fullName;
    }
    @RequestMapping("/env/user/fullName")
    public String getFullNameFromEnv(){
        return environment.getProperty("user.fullName");
    }


}
