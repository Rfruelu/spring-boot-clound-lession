package com.lujia.controller;

import com.lujia.domain.User;
import com.lujia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author :lujia
 * @date :2018/11/20  9:31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/login")
    public String login(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password, HttpServletRequest request) {

        String result = "login success";
        User user = userRepository.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("username"), name));
                return null;
            }
        });

        if (user == null) {
            result = "login failed";
        } else {
            if (!user.getPassword().equals(password)) {
                result = "账号或密码不正确";
            } else {
                request.getSession().setAttribute("session-user", user);
            }
        }
        return result;
    }


    @RequestMapping("/findByEmail")
    public List<User> findByEmail(@RequestParam("email") String email) {
        List<User> byEmail = userRepository.findByEmail(email);

        return byEmail;
    }

    @RequestMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("password") String password) {
        User user = new User();
        user.setId("test");
        user.setUsername(name);
        user.setPassword(password);
        User save = userRepository.save(user);
        if (save != null) {
            return "success";
        }
        return "failed";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("name") String name, @RequestParam("password") String password) {
        userRepository.deleteByNameAndPassword(name, password);
        return "success";
    }

    @RequestMapping("/cutPage")
    public List<User> cutPage(int page) {
        User user = new User();
        if (page != 0) {

            user.setPage(page);
        }
        user.setSize(10);

        Sort.Direction direction=!Sort.DEFAULT_DIRECTION.toString().equalsIgnoreCase("desc")?Sort.Direction.DESC: Sort.Direction.ASC;

        Sort sort=new Sort(direction,user.getStorIdx());
        PageRequest pageRequest = new PageRequest(user.getPage() - 1, user.getSize(),sort);


        return userRepository.findAll(pageRequest).getContent();
    }

}
