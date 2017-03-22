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
public class UserService implements UserServiceInterface {

	UserDao userDaoImp;

	@Autowired
	public void setUserDaoImp(UserDao userDaoImp) {
		this.userDaoImp = userDaoImp;
	}

	@Override
	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers(Integer offset, Integer maxResults) {

		return userDaoImp.getAllUser(offset, maxResults);
	}

	@Override
	public void deleteUser(int user_id) {

		userDaoImp.deleteUser(user_id);
	}

	@Override
	public User getUser(int user_id) {

		return userDaoImp.getUser(user_id);
	}

	@Override
	public void updateUser(User user) {

		userDaoImp.updateUser(user);

	}

	@Override
	public boolean exists(String username) {
		return userDaoImp.exists(username);
	}

	@Override
	public boolean createUser(User user) {
		return userDaoImp.createUser(user);

	}

	@Override
	public Long count() {
		return userDaoImp.count();
	}

}
