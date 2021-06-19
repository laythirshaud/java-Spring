package com.example.Dojo.Survey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerDojo {
	
	@RequestMapping("/")
	public String dashboard() {
		return "index.jsp";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String index(@RequestParam(value = "name") String name, @RequestParam(value = "SanJose") String SanJose,
			@RequestParam(value = "python") String python, @RequestParam(value = "comment") String comment,HttpSession session) {
			
				session.setAttribute("name", name);
				session.setAttribute("SanJose", SanJose);
				session.setAttribute("python", python);
				session.setAttribute("comment", comment);
			
		return "redirect:/result";

	}
	@RequestMapping("/result")
	public String welcome() {
		return "welcom.jsp";
	}
	@RequestMapping("/back")
	public String back() {
		return "redirect:/";
	}

	
}
