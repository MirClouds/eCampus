package com.sbbusba.ecampus.dao;

import java.util.List;

import com.sbbusba.ecampus.model.Student;

public interface StudentDao {

	public void createStudent(Student student);

	public void deleteStudent(int student_id);

	public void updateStudent(Student user);

	public Student getStudent(int student_id);

	public boolean existsStudent(String username);

	public List<Student> getAllStudent(Integer offset, Integer maxResults);

	public Long count();

}