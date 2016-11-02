package com.sbbusba.ecampus.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sbbusba.ecampus.model.User;
import com.sbbusba.ecampus.service.UserServiceInterface;

@Controller
public class UserController {

	private UserServiceInterface userService;

	 
	@Autowired
	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}

	@RequestMapping("login")
	public String showLogin() {

		return "login";
	}

	@RequestMapping("loggedout")
	public String loggedOut() {

		return "loggedout";
	}

	@RequestMapping("users")
	public String showAllUsers(Model model) {

		List<User> user = userService.getAllUsers();
		model.addAttribute("user", user);
		return "users";
	}

	@RequestMapping("add-user")
	public String AddUser(Model model) {
		model.addAttribute("user", new User());
		return "add-user";
	}

	@RequestMapping(value = { "/delete/{username}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
		return "redirect:/users";
	}

	/*
	 * @RequestMapping (value={ "/useredit/{username}" }, method =
	 * RequestMethod.GET) public String getUser(@PathVariable("username") String
	 * username,Model model) { model.addAttribute("user",
	 * this.userService.getUser(username));
	 * //model.addAttribute("listOfCountries", this.userService.getAllUsers());
	 * return "useredit"; }
	 */
	@RequestMapping("/useredit/{username}")
	public String getUser(@PathVariable("username") String username,
			Map<String, Object> map) {
		map.put("user", userService.getUser(username));
		map.put("userList", userService.getAllUsers());
		return "useredit";
	}

	@RequestMapping(value = "/AddORUpdate", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("user") User user,
			BindingResult result) {

		userService.updateUser(user);

		return "redirect:/users";
	}

	@RequestMapping(value = "added-user", method = RequestMethod.POST)
	public String addedUser(Model mode, @Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "add-user";

		}

		try {
			userService.createUser(user);

		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username",
					"Username already exist!");
			return "add-user";
		}
		return "redirect:/users";

	}
}
