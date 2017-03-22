package com.sbbusba.ecampus.dao;

import java.util.List;

import com.sbbusba.ecampus.model.User;

public interface UserDao {

	public boolean createUser(User user);

	public void deleteUser(int user_id);

	public List<User> getAllUser(Integer offset, Integer maxResults);

	public Long count();

	public void updateUser(User user);

	public User getUser(int user_id);

	public boolean exists(String username);

}