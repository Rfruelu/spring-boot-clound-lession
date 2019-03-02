package com.example.lujia.repositroy;

import com.example.lujia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by LuTshoes on 2017/7/17 0017.
 * lutshoes@163.com
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByAge(Integer age);

    List<User> findByNameAndAge(String name, Integer age);

    @Query("select u from User u where u.age >:age")
    List<User> withAge(@Param("age") Integer age);

}
