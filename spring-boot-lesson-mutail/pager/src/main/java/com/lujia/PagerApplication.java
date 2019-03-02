package com.lujia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.lujia")
public class PagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagerApplication.class, args);
	}
}
