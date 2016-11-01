package com.sbbusba.ecampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbbusba.ecampus.dao.StudentDao;
import com.sbbusba.ecampus.model.User;

@Service("studentService")
public class StudentService {

	StudentDao studentDao;
	
	
	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	public List<User> getCurrentStudent() {
		return studentDao.getAllStudents();
	}

	public void createStudents(User user) {
		studentDao.createStudent(user);

	}

	public boolean exists(String username) {
		return studentDao.exists(username);
	}

	 
}
