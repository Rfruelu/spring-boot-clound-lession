package com.lujia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringlessonjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringlessonjpaApplication.class, args);
	}
}
