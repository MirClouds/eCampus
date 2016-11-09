package com.sbbusba.ecampus.dao;

import java.util.List;

import com.sbbusba.ecampus.model.Student;

public interface StudentDao {

	public boolean createStudent(Student student);

	public void deleteStudent(String username);

	public void updateStudent(Student user);

	public Student getStudent(String username);

	public boolean existsStudent(String username);

	public List<Student> getAllStudent(Integer offset, Integer maxResults);

	public Long count();

}