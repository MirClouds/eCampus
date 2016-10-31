package com.sbbusba.ecampus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbbusba.ecampus.dao.User;
import com.sbbusba.ecampus.service.UserService;

@Controller
public class LoginController {
	
	private UserService userService;

	@Autowired
	public void setStudentService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("login")
	public String showLogin(){
		
		return "login";
	}
	
	@RequestMapping("loggedout")
	public String loggedOut(){
		
		return "loggedout";
	}
	
	@RequestMapping("users")
	public String showAllUsers(Model model){
		
		List<User> user = userService.getAllUsers();
		model.addAttribute("user", user);
		return "users";
	}
	
}
