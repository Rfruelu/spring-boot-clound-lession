package com.example.lujia;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author :lujia
 * @date :2018/7/21  19:27
 */
@Configuration
public class SpringAnnotationDemo {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(SpringAnnotationDemo.class);

        annotationConfigApplicationContext.refresh();

        System.out.println(annotationConfigApplicationContext.getBean(SpringAnnotationDemo.class));

    }
}
