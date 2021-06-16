package com.example.Counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Home {
	@RequestMapping("")
	public String layth(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(session.getAttribute("count") != null) {
			session.setAttribute("count",(int)session.getAttribute("count")+1);
		}
		else {
			 session.setAttribute("count", 0);
		}
	
		return "index.jsp";
	}
	@RequestMapping("/Counter")
	
	public String index(){

		return "index2.jsp";
		
	}
}
