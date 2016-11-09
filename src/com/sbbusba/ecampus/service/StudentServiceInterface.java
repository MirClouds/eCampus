package com.sbbusba.ecampus.service;

import java.util.List;

import com.sbbusba.ecampus.model.Student;

public interface StudentServiceInterface {

	public void deleteStudent(String username);

	public Student getStudent(String username);

	public void updateStudent(Student student);

	public boolean existsStudent(String username);

	public boolean createStudent(Student student);

	public List<Student> getAllStudent(Integer offset, Integer maxResults);
	public Long count();

}
