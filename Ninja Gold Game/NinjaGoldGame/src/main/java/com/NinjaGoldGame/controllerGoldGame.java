package com.NinjaGoldGame;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class controllerGoldGame {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
			}
		return "index.jsp";
		
	}
	ArrayList<String> arr = new ArrayList<String>();
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String index(@RequestParam(value = "hidden") String gold,HttpSession session) {
		if (session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
			}
		int allGold=(int)session.getAttribute("gold");
		
		if (gold.equals("farm")) {
			allGold += (int) Math.floor((Math.random()*11)+10);
			arr.add("You entered farm and earned "+allGold+" of gold"+ new Date());
		}
		else if(gold.equals("cave")) {
			allGold+= (int)Math.floor((Math.random()*6)+5);
			arr.add("You entered cave and earned "+allGold+" of gold"+ new Date());
		}else if(gold.equals("house")) {
			allGold+= (int)Math.floor((Math.random()*4)+2);
			arr.add("You entered house and earned "+allGold+" of gold"+ new Date());
		}
		else if(gold.equals("casino")) {
			allGold+= (int)Math.floor((Math.random()*101)-50);
			if(allGold<0) {				
				arr.add("<p style='color: red'>You entered casino and earned"+allGold+" of gold"+ new Date()+"</p>");
			}else {				
				arr.add("You entered casino and earned "+allGold+" of gold"+ new Date());
			}
			
			;
		}
		session.setAttribute("gold", allGold);
		session.setAttribute("arr", arr);
		return "redirect:/";
		
		
	}
	


}
