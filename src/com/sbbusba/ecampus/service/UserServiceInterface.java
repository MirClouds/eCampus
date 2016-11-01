package com.sbbusba.ecampus.service;

import java.util.List;

import com.sbbusba.ecampus.model.User;

public interface UserServiceInterface {

	public void deleteUser(String username);

	public User getUser(String username);

	public void updateUser(User user);

	public boolean exists(String username);

	public boolean createUser(User user);
	
	public List<User> getAllUsers();

}
