package com.sbbusba.ecampus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sbbusba.ecampus.model.User;
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
	
	 @RequestMapping(value = { "/delete/{username}" }, method = RequestMethod.GET)
	    public String deleteUser(@PathVariable String username) {
	        userService.deleteUser(username);
	        return "redirect:/users";
	    }
	 
/*	 @RequestMapping (value={ "/useredit/{username}" }, method = RequestMethod.GET)
	    public String getUser(@PathVariable("username") String username,Model model) {  
	         model.addAttribute("user", this.userService.getUser(username));
	            //model.addAttribute("listOfCountries", this.userService.getAllUsers());  
	            return "useredit";  
	    }  
	 */
	    @RequestMapping("/useredit/{username}")
	    public String getUser(
	        @PathVariable("username")String username,
	        Map<String, Object> map)
	    {
	        map.put("book", userService.getUser(username));
	        map.put("userList", userService.getAllUsers());
	        return "useredit";
	    }


	
}
