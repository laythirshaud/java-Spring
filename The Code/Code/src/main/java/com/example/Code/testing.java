package com.example.Code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class testing {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="username") String username) {
		if (username.equals("bushido")){
			return "index1.jsp";
		}
		
		return "redirect:/errorcoding";

	}
	
	    @RequestMapping("/errorcoding")
	
	    
	        public String flashMessages(RedirectAttributes redirectAttributes) {
	            redirectAttributes.addFlashAttribute("error", "You must train harder!");
	        return "redirect:/";
	    }

}

