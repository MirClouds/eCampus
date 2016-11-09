package com.sbbusba.ecampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbbusba.ecampus.dao.StudentDao;
import com.sbbusba.ecampus.model.Student;

@Service("studentService")
@Repository
@Transactional
public class StudentService implements StudentServiceInterface {

	StudentDao studentDaoImp;

	@Autowired
	public void setstudentDaoImp(StudentDao studentDaoImp) {
		this.studentDaoImp = studentDaoImp;
	}

	@Override
 	@Secured("ROLE_ADMIN")
	public List<Student> getAllStudent(Integer offset, Integer maxResults){
		  return studentDaoImp.getAllStudent(offset, maxResults);

		//return studentDaoImp.getAllStudent();
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void deleteStudent(String username) {

		studentDaoImp.deleteStudent(username);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public Student getStudent(String username) {

		return studentDaoImp.getStudent(username);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public void updateStudent(Student student) {

		studentDaoImp.updateStudent(student);

	}

	@Override
	public boolean existsStudent(String username) {
		return studentDaoImp.existsStudent(username);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public boolean createStudent(Student student) {
		return studentDaoImp.createStudent(student);

	}
	
	@Override
	public Long count(){
		  return studentDaoImp.count();
		 }
}
