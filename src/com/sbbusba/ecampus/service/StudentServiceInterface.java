package com.sbbusba.ecampus.service;

import java.util.List;

import com.sbbusba.ecampus.model.Student;

public interface StudentServiceInterface {

	public void deleteStudent(int student_id);

	public Student getStudent(int student_id);

	public void updateStudent(Student student);

	public boolean existsStudent(String username);

	public void createStudent(Student student);

	public List<Student> getAllStudent(Integer offset, Integer maxResults);
	public Long count();

}
