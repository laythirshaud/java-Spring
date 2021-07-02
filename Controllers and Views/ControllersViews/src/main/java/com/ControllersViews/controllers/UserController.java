package com.ControllersViews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ControllersViews.models.Event;
import com.ControllersViews.models.Message;
import com.ControllersViews.models.User;
import com.ControllersViews.services.EventService;
import com.ControllersViews.services.UserService;
import com.ControllersViews.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final EventService eventsService;

	


	public UserController(UserService userService, UserValidator userValidator, EventService eventsService) {
		super();
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventsService = eventsService;
	}



	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}



	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "/registrationPage.jsp";
		} else {
			User u=userService.registerUser(user) ;
			session.setAttribute("user_Id",u.getId());
			
			return "redirect:/events";
		}

	}

	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean isAuthenticated =userService.authenticateUser(email, password) ;
		if(isAuthenticated) {
			User u=userService.findByEmail(email) ;
			session.setAttribute("user_Id",u.getId());
			return "redirect:/events";
		}else {
			model.addAttribute("error","invalid credentials. please try again");
			User user = new User();
			model.addAttribute("user",user);
			return "registrationPage.jsp";
		}
			
		
	}

	 @RequestMapping("/events")
	    public String home(HttpSession session, Model model,@ModelAttribute("event")Event event) {
	        if(session.getAttribute("userId")==null){
	            return "redirect:/";
	        }
	        else {
	            User user = eventsService.findUserById((Long) session.getAttribute("userId"));
	            model.addAttribute("user",user);
	            model.addAttribute("eventwithstate",eventsService.allEventsWithState(user.getState()));
	            model.addAttribute("eventwithoutstate",eventsService.allEventsWithoutState(user.getState()));
	            return "events.jsp";
	        }
	    }
	 @RequestMapping(value = "/events",method = RequestMethod.POST)
	    public String createEvent(@Valid @ModelAttribute("event")Event event,BindingResult result,HttpSession session,Model model){
	        if(result.hasErrors()){
	            User user = eventsService.findUserById((Long) session.getAttribute("userId"));
	            model.addAttribute("user",user);
	            return "events.jsp";
	        }
	        else{
	            User user=eventsService.findUserById((Long) session.getAttribute("userId"));
	            Event event1=eventsService.createEvent(event,user);
	            return "redirect:/events";
	        }
	    }
	 @RequestMapping("/events/{id}/edit")
	    public String editEvent(@PathVariable("id")Long id,@ModelAttribute("event")Event event,Model model,HttpSession session){
	        if(session.getAttribute("userId")==null){
	            return "redirect:/";
	        }
	        model.addAttribute("event",eventsService.findEvent(id));
	        return "edit.jsp";
	    }
	 
	 @RequestMapping(value = "/events/{id}/edit",method = RequestMethod.PUT)
	    public String updateEvent(@PathVariable("id")Long id,@Valid @ModelAttribute("event")Event event,BindingResult result){
	        if(result.hasErrors()){
	            return "edit.jsp";
	        }else{
	            eventsService.updateEvent(event);
	            return "redirect:/events";

	        }
	 }
	 @RequestMapping("/events/{id}")
	    public String showEvent(@PathVariable("id")Long id, @ModelAttribute("message")Message message, Model model,HttpSession session){
	        if(session.getAttribute("userId")==null){
	            return "redirect:/";
	        }
	        model.addAttribute("event",eventsService.findEvent(id));
	        model.addAttribute("eventnumber",eventsService.countByJoinedUsers(id));
	        return "show.jsp";
	    }
	 
	 @RequestMapping(value = "/events/{id}",method = RequestMethod.POST)
	    public String addMessage(@PathVariable("id")Long event_id,@Valid @ModelAttribute("message")Message message,BindingResult result, Model model,HttpSession session){
	        if(result.hasErrors()) {
	            model.addAttribute("event", eventsService.findEvent(event_id));
	            return "show.jsp";
	        }else{
	            eventsService.createMessage(message,event_id,(Long)session.getAttribute("userId"));
	            return "redirect:/events/"+event_id;
	        }
	    }
	 @RequestMapping("/events/{id}/delete")
	    public String deleteEvent(@PathVariable("id")Long id){
	        eventsService.deleteEvent(id);
	        return "redirect:/events";
	    }
	 @RequestMapping("events/{id}/join")
	    public String joinEvent(@PathVariable("id")Long event_id,HttpSession session){
	        Long user_id=(Long)session.getAttribute("userId");
	        eventsService.joinEvent(event_id,user_id);
	        return "redirect:/events";
	    }
	 @RequestMapping("events/{id}/cancel")
	    public String cancelEvent(@PathVariable("id")Long event_id,HttpSession session){
	        Long user_id=(Long)session.getAttribute("userId");
	        eventsService.cancelEvent(event_id,user_id);
	        return "redirect:/events";
	    }

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/registration";
	}
	
	
	
	
}


