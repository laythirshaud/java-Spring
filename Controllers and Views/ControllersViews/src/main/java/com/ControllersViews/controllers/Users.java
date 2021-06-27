package com.ControllersViews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ControllersViews.models.User;
import com.ControllersViews.services.UserService;

@Controller
public class Users {
	private final UserService userService;

	public Users(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		if (result.hasErrors()) {
			return "/registrationPage.jsp";
		} else {
			User u=userService.registerUser(user) ;
			session.setAttribute("user_Id",u.getId());
			
			return "redirect:/home";
		}

	}

	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean isAuthenticated =userService.authenticateUser(email, password) ;
		if(isAuthenticated) {
			User u=userService.findByEmail(email) ;
			session.setAttribute("user_Id",u.getId());
			return "redirect:/home";
		}else {
			model.addAttribute("error","invalid credentials. please try again");
			return "loginPage.jsp";
		}
			
		
	}

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId=(Long) session.getAttribute("user_Id");
		User u=userService.findUserById(userId);
		model.addAttribute("user",u);
		return "homePage.jsp";
	
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}


