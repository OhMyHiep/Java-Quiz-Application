package com.beaconfire.personalProject.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beaconfire.personalProject.daoImpl.UserDaoImpl;
import com.beaconfire.personalProject.domain.User;
import com.beaconfire.personalProject.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	
	@PostMapping("loggingIn")
	public String login(@ModelAttribute User user, Model model, HttpSession session) {
		User person= userService.getUser(user);
		System.out.println("logging user in");
		if (person==null) {
			System.out.println("invalid loggin");
			model.addAttribute("Error","Invalid Credentials");
			return "login";
		}
		else {
			System.out.println("valid credentials");
			session.setAttribute("user",person);
			System.out.println("user: "+session.getAttribute("user"));
			return "home";
		}
	}
	
	
	@GetMapping
	public String isLoggedIn(HttpSession session){
		System.out.println("in user controller, checking if logged in");
		User person=(User)session.getAttribute("user");
		System.out.println(session.getAttribute("user"));
		if(person==null) {
			return "login";
		}
		return "home";
	}
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if (session != null) {
	        session.invalidate();
	    }
		return "login";
	}
	 
	
	@GetMapping("add")
	public String toRegisterPage(Model model) {
		System.out.println("to register page");
		User user= new User ();
		model.addAttribute("user", user);
		return "register";
	}
	 
	@GetMapping("admin")
	public String loadUsers(HttpSession session) {
		
		session.setAttribute("userList",userService.getAllusers());
		
		return "adminUserView";
		
	}
	
	
	@PostMapping("register")
	public String addUser(@ModelAttribute User user, Model model) {
		userService.insertRegstration(user);
//		System.out.println("first name: "+user.getFirstName());
//		System.out.println("lastName: "+user.getLastName());
//		System.out.println("username: "+user.getUsername());
//		System.out.println("password: "+user.getPassword());
//		System.out.println("email: "+user.getEmail());
//		System.out.println("role:xm"+user.getRole().equals(""));
		model.addAttribute("registered","You are Successfully Registered");
		return "login";
	} 
	
	@GetMapping("/status/idx/{index}")
	public String changeStatus(@PathVariable Optional<Integer> index, HttpSession session) {
		if(index.isPresent()) {
			List<User> userList= (List<User>) session.getAttribute("userList");
			User user=userList.get(index.get());	
			user.changeStatus();
			userService.updateUser(user);
		}
		
		return "adminUserView";
	}
	
	@Autowired
	public void setRegister(UserService userService) {
		this.userService = userService;
	}
	
	
	
}
