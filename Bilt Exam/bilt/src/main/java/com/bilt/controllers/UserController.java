package com.bilt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bilt.models.Course;
import com.bilt.models.User;
import com.bilt.services.CourseService;
import com.bilt.services.UserService;
import com.bilt.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final CourseService courseService;

	

	

	public UserController(UserService userService, UserValidator userValidator, CourseService courseService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.courseService = courseService;
	}



	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user) {
		return "index.jsp";
	}



	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "/index.jsp";
		} else {
			User u=userService.registerUser(user) ;
			session.setAttribute("user_Id",u.getId());
			
			return "redirect:/courses";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean isAuthenticated =userService.authenticateUser(email, password) ;
		if(isAuthenticated) {
			User u=userService.findByEmail(email) ;
			session.setAttribute("user_Id",u.getId());
			return "redirect:/courses";
		}else {
			model.addAttribute("error","invalid credentials. please try again");
			User user = new User();
			model.addAttribute("user",user);
			return "index.jsp";
		}
	}

	
	@RequestMapping("/courses")
	public String homepage(HttpSession session, Model model) {

		if (session.getAttribute("user_Id") != null) {
			
			Long userId = (Long) session.getAttribute("user_Id");
			User u = userService.findUserById(userId);
			model.addAttribute("user", u);

			List<Course> courseList = courseService.findAllCourses();
			model.addAttribute("courses", courseList);
			return "homePage.jsp";

		} else {
			System.out.println("You have not logined");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/courses/new")
	public String courseCreation(@ModelAttribute("course") Course myCourse) {
		return "course.jsp";
		
	}
	@PostMapping("/courses/new")
	public String createCourse(@Valid @ModelAttribute("course") Course myCourse, BindingResult result) {
		if (result.hasErrors()) {
			return "course.jsp";
		} else {
			courseService.createCourse(myCourse);
			return "redirect:/courses";
		}
	}
	
	
	@RequestMapping("courses/{id}")
	public String displayCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
		Course myCourse = courseService.findCourseById(myId);
		model.addAttribute("course", myCourse);
		List<User> users = myCourse.getUsers();
		Long userId = (Long) session.getAttribute("user_Id");
		User u = userService.findUserById(userId);
		model.addAttribute("currentUser",u);
		return "courseinfo.jsp";
	}
	
	
	
	@RequestMapping("/courses/add/{id}")
	public String addCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_Id");
		User u = userService.findUserById(userId);
		Course course = courseService.findCourseById(myId);
		
		u.getCourses().add(course);
		userService.updateUser(u);
		
		
		return "redirect:/courses";
	}
	
	
	@RequestMapping("/courses/{id}/edit")
	public String editPage(@ModelAttribute("course") Course myCourse, @PathVariable("id") Long myId, Model model) {
		Course course = courseService.findCourseById(myId);
		model.addAttribute("course", course);
		return "edit.jsp";
	}
	
	@PostMapping("/courses/update")
	public String updateCourse(@Valid @ModelAttribute("course") Course myCourse, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			List<User> myStudents =myCourse.getUsers();
			courseService.updateCourse(myCourse);
			
			return "redirect:/courses";
		}
	}
	
	@RequestMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable("id") Long id) {
		Course myCourse = courseService.findCourseById(id);
		if (myCourse != null) {
			courseService.deleteCourse(myCourse);
			return "redirect:/courses";
		} else {
			return "redirect:/courses";
		}

	}
	
	
	@RequestMapping("/courses/{id}/delete")
	public String removeUserFromCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_Id");
		User u = userService.findUserById(userId);
		Course course = courseService.findCourseById(myId);
		
		u.getCourses().remove(course);
		userService.updateUser(u);
		
		return "redirect:/courses";
	}
	
	
	@RequestMapping("/courses/{id}/add")
	public String addUserToCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		Course course = courseService.findCourseById(myId);
		
		u.getCourses().add(course);
		userService.updateUser(u);
		
		return "redirect:/courses";
	}


	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/courses";
	}
}


