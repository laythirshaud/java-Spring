package com.any.GettingFamiliar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("{track}")
	public String Dojo(@PathVariable("track") String track) {
		return "The " + track + "  is awesome!";
	}

	@RequestMapping("am/{track1}")
	public String burbank(@PathVariable("track1") String track1) {
		
		String[] s=track1.split("-");
		String s1=s[0];
		String s2=s[1];
		
		return s1.toUpperCase()+ " " + s2.toUpperCase() ;
	}
	@RequestMapping("z/{track}")
	public String san(@PathVariable("track")String track) {
		String [] l=track.split("-");
		String l1=l[0];
		String l2=l[1];
		
		return l1.substring(0, 1).toUpperCase()+ "" +l2.substring(0, 1).toUpperCase();
	}
	

}
