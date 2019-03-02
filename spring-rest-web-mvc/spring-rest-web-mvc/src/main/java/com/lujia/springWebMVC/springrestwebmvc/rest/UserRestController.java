package com.lujia.springWebMVC.springrestwebmvc.rest;

import com.lujia.springWebMVC.springrestwebmvc.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link} RestController
 * @author :lujia
 * @date :2018/7/22  15:03
 */
@RestController
public class UserRestController {



    @GetMapping(value = "/user/{age}")
    public User getUser(@PathVariable Integer age, @RequestParam(required = false) String name){
        User user=new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }
    @RequestMapping(value = "/user/get",
            consumes = MediaType.APPLICATION_XML_VALUE,//接受请求的内容类型 context-type
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE//响应内容的类型 accept
    )
    public User get(@RequestBody User user){

        return user;
    }
    @RequestMapping(value = "/user/jsonToProperties",
            consumes = "application/properties-user",//接受请求的内容类型
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE//响应内容的类型
    )
    public User jsonToProperties(@RequestBody User user){

        return user;
    }


    @RequestMapping(value = "/user/propertiesToJson",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,//接受请求的内容类型
            produces = "application/properties-user"//响应内容的类型
    )
    public User propertiesToJson(@RequestBody User user){

        return user;
    }

}
