package com.sbbusba.ecampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.sbbusba.ecampus.dao.User;
import com.sbbusba.ecampus.dao.UserDaoImp;

@Service("studentService")
public class UserService {

	UserDaoImp userDaoImp;

	@Autowired
	public void setStudentdao(UserDaoImp studentdao) {
		this.userDaoImp = studentdao;
	}

	public List<User> getCurrentStudent() {
		return userDaoImp.getStudents();
	}

	public void createStudents(User user) {
		userDaoImp.createStudent(user);
		
	}
	
	public boolean exists(String username) {
		return userDaoImp.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		
		return userDaoImp.getUsers();
	}
 
	
	


}
