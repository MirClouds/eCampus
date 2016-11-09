package com.sbbusba.ecampus.controller;

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

import com.sbbusba.ecampus.model.Student;
import com.sbbusba.ecampus.service.StudentServiceInterface;

@Controller
public class StudentController {
	
	private StudentServiceInterface studentService;

	@Autowired
	public void setStudentService(StudentServiceInterface studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("students")
	public String showAllStudents(Model model, Integer offset, Integer maxResults){
		  model.addAttribute("student", studentService.getAllStudent(offset, maxResults));
		  model.addAttribute("count", studentService.count());
		  model.addAttribute("offset", offset);
		  model.addAttribute("addStudent", new Student());
		  return "students";
	}

	@RequestMapping("add-student")
	public String AddStudent(Model model) {
		model.addAttribute("addStudent", new Student());
		return "add-student";
	}

	@RequestMapping(value = { "/deleteStudent/{username}" }, method = RequestMethod.GET)
	public String deleteStudent(@PathVariable String username) {
		studentService.deleteStudent(username);
		return "redirect:/students";
	}

 
	@RequestMapping("/studentsedit/{username}")
	public String getStudent(@PathVariable("username") String username,
			Map<String, Object> map, Integer offset, Integer maxResults) {
		map.put("student", studentService.getStudent(username));
		 map.put("studentList", studentService.getAllStudent(offset, maxResults));
		return "studentedit";
	}

	@RequestMapping(value = "/updateStudents", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("student") Student student,
			BindingResult result) {

		studentService.updateStudent(student);

		return "redirect:/students";
	}

	@RequestMapping(value = "added-students", method = RequestMethod.POST)
	public String addedStudent(Model mode, @Valid Student student, BindingResult result) {

		if (result.hasErrors()) {
			return "add-student";

		}
		String usere = student.getUsername();
		if (studentService.existsStudent(usere)) {
		
			System.out.println("exist user");
			
			mode.addAttribute("msg", "user exist already");
			mode.addAttribute("addStudent", student);
			return "add-student";
		}
		try {
			studentService.createStudent(student);

		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.student.username",
					"Username already exist!");
			return "add-student";
		}
		return "redirect:/students";

	}
}
