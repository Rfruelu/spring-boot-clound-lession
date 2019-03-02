package com.example.lujia.repository;

import com.example.lujia.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by LuTshoes on 2017/7/18 0018.
 * lutshoes@163.com
 */
//定制rest的path
@RepositoryRestResource(path="language")
public interface LanguageRepository extends JpaRepository<Language,Long>{

    @RestResource(path = "queryWithAge")//定制资源的url
    @Query("select l from Language l where l.age>:age")
    List<Language> queryWithAge(@Param("age") Integer age);
}
