package com.lujia.controller;

import com.lujia.demain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :lujia
 * @date :2018/11/27  15:49
 */
@Controller
public class UserController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request , User user){

        request.setAttribute("user",user);
        return "index";
    }
}
