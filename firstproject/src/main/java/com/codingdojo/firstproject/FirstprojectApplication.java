package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello() {
		return "<h1>hello client How are you doing ?";

	}

	@RequestMapping("/random")
	public String random() {
		return "Spring boot is great ! so easy to just respond with strings";

	}

}
