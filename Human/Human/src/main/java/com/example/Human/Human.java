package com.example.Human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Human {
	@RequestMapping("/")
	public String index() {
		return "<h1> hello Human </h1> <br> <br> <P>Welcom to Springboot</p>";
	}
	@RequestMapping("/dojo")
	public String layth(@RequestParam(value ="name") String search) {
		
		return "<a href=http://127.0.0.1:8080/ style ='float:right'> go back</a> <h1>Hello  "+ search+"</h1>"+"<br> <br> <P>Welcom to Springboot</p>";
 
	}

}
