package com.any.DisplayDate;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Testingg {
	private static final String Date=null;

	@RequestMapping("")
	public String layth() {
		return "index2.jsp";
	}
	@RequestMapping("/date")
	public String layth2(Model mstSystem) {
		Date today =new Date();
		mstSystem.addAttribute("dayNow",today);
		return "date.jsp" ;
		
	}
	@RequestMapping("/time")
	public String layth3(Model mstSystem) {
		Format time =new SimpleDateFormat("hh:mm:ss a");
		String strResult =time.format(new Date());
		mstSystem.addAttribute("timeNow",strResult);
		return "time.jsp" ;
	
}
}
