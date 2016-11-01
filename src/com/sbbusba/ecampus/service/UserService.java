package com.sbbusba.ecampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbbusba.ecampus.dao.UserDao;
import com.sbbusba.ecampus.model.User;

@Service("userService")
@Repository
@Transactional
public class UserService {

	UserDao userDaoImp;

	
	@Autowired
	public void setUserDaoImp(UserDao userDaoImp) {
		this.userDaoImp = userDaoImp;
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {

		return userDaoImp.getAllUser();
	}

public void deleteUser(String username) {

		  userDaoImp.deleteUser(username);
	}


public User getUser(String username) {
	 
	return userDaoImp.getUser(username);
}

}
