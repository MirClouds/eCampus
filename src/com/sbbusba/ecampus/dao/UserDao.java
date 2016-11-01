package com.sbbusba.ecampus.dao;

import java.util.List;

import com.sbbusba.ecampus.model.User;

public interface UserDao {
    
	public boolean createUser(User user);
   
  
	public void deleteUser(String username);
    
	public List<User> getAllUser();
    
	public void updateUser(User user);
	public User getUser(String username); 
	public boolean exists(String username);


}