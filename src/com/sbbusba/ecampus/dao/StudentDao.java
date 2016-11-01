package com.sbbusba.ecampus.dao;

import java.util.List;

import com.sbbusba.ecampus.model.User;

public interface StudentDao {
    
	public boolean createStudent(User student);
   
  
	public boolean deleteStudent(String username);
    
	public List<User> getAllStudents();
	
	public boolean exists(String username);
    
	public User updateStudent(User student);
	public User getStudent(String username);   

}