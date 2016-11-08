package com.sbbusba.ecampus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sbbusba.ecampus.model.User;
import com.sbbusba.ecampus.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("students")
	public String showhome(Model model) {
		List<User> user = studentService.getCurrentStudent();
		model.addAttribute("student", user);
		return "students";
	}

	@RequestMapping("add-students")
	public String addStudents(Model model) {
		model.addAttribute("user", new User());
		return "add-students";
	}

	@RequestMapping(value = "added-students", method = RequestMethod.POST)
	public String addedStudents(Model mode, @Valid User user,
			BindingResult result) {

		if (result.hasErrors()) {
			return "add-students";

		}

		user.setAuthority("ROLE_STUDENT");

		if (studentService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username",
					"This username already exists!");
			return "add-students";
		}

		try {
			studentService.createStudents(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username",
					"Username already exist!");
			return "add-students";
		}

		return "added-students";
	}

}
