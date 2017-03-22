package com.sbbusba.ecampus.service;

import java.util.List;

import com.sbbusba.ecampus.model.User;

public interface UserServiceInterface {

	public void deleteUser(int user_id);

	public User getUser(int user_id);

	public void updateUser(User user);

	public boolean exists(String username);

	public boolean createUser(User user);
	
	public List<User> getAllUsers(Integer offset, Integer maxResults);
	public Long count();

}
