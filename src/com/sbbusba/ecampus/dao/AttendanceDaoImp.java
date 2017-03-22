package com.sbbusba.ecampus.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sbbusba.ecampus.model.Attendance;
import com.sbbusba.ecampus.model.Student;

@Component("attendanceDaoImp")
@Repository
public class AttendanceDaoImp implements AttendanceDao {
 
 
	@Autowired
	private SessionFactory sessionFactory;

/*	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}*/
	 
	// add user
	/*@Override
	public boolean createStudent(Student student) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", student.getName());
		params.addValue("username", student.getUsername());
		params.addValue("password",
				passwordEncoder.encode(student.getPassword()));

		params.addValue("rollnumber", student.getRollnumber());
		params.addValue("mobile", student.getMobile());
		params.addValue("enabled", student.getEnabled());
		params.addValue("authority", student.getAuthority());
		params.addValue("image", student.getImage());

		student.setAuthority("ROLE_STUDENT");
		return jdbc
				.update("insert into student (name, username, password, rollnumber, mobile, enabled, image, authority) values (:name, :username, :password, :rollnumber, :mobile, :enabled, :image, 'ROLE_STUDENT')",
						params) == 1;
	}*/
	
	@Override
	public void createAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		attendance.setDate(new Date());

		sessionFactory.getCurrentSession().save(attendance);
	}

	

}
