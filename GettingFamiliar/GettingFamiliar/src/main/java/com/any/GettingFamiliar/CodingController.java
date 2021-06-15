package com.any.GettingFamiliar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
@RequestMapping("")
public String display() {
	return "Hello Coding Dojo!";


}
@RequestMapping("/python")
public String display2() {
	return "Python/Django was awesome!";


}
@RequestMapping("/java")
public String display3() {
	return "Java/Spring is better!";


}
}