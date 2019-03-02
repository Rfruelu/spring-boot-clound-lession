package com.example.lujia.controller;

import com.example.lujia.entity.User;
import com.example.lujia.repositroy.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LuTshoes on 2017/7/17 0017.
 * lutshoes@163.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public String save(String name, Integer age) {
        logger.debug("save");
        User user = new User(name, age);
        userRepository.save(user);
        return "save success";

    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        logger.debug("delete");
        userRepository.delete(id);
        return "delete success";
    }

    @RequestMapping("/queryByName")
    public List<User> queryByName(String name) {
        logger.debug("queryByName");
        List<User> byName = userRepository.findByName(name);
        return byName;
    }
    @RequestMapping("/queryByAge")
    public List<User> queryByAge(Integer age) {
        logger.debug("queryByAge");
        return userRepository.findByAge(age);
    }
    @RequestMapping("/queryWithAge")
    public List<User> queryWithAge(Integer age) {
        logger.debug("queryWithAge");
        return  userRepository.withAge(age);

    }
    @RequestMapping("/sort")
    public List<User> sort() {
        logger.debug("sort");
        List<User> sort = userRepository.findAll(new Sort(Sort.Direction.DESC,"age"));
        return sort;
    }
    @RequestMapping("/page")
    public List<User> page(int page,int size) {
        logger.debug("page");
        final Page<User> all = userRepository.findAll(new PageRequest(page, size));
        return all.getContent();
    }

}
