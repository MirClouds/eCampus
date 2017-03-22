package com.sbbusba.ecampus.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sbbusba.ecampus.model.Attendance;
import com.sbbusba.ecampus.service.AttendanceServiceInterface;

@Controller
public class AttendanceController {

	private AttendanceServiceInterface attendanceService;

	@Autowired
	public void setAttendanceService(
			AttendanceServiceInterface attendanceService) {
		this.attendanceService = attendanceService;
	}

	@RequestMapping("/addAttendance")
	public String showHome(Attendance attendance) {
	 
		// model.addAttribute("attendance", new Attendance());

		return "addAttendance";
	}

	@RequestMapping(value = "/addAtt", method = RequestMethod.POST)
	public String addedAttendance(Attendance attendance, Model model) {

		System.out.println("before");

		attendanceService.createAttendance(attendance);
		model.addAttribute("AttSuccess", "Success");


		System.out.println("success");

		return "redirect:/addAttendance";

	}

}
