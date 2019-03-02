package com.example.lujia;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class DemoClientApplication {

	@Value("${server.port}")
	private String port;
	public static void main(String[] args) {
		SpringApplication.run(DemoClientApplication.class, args);
	}
	@RequestMapping("/hello")
	public String sayHello(@RequestParam String name){
		return "hello "+name+" i am form port "+port;
	}
}
