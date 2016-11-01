package com.sbbusba.ecampus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sbbusba.ecampus.model.User;

@Component("studentDaoImp")
public class StudentDaoImp implements StudentDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Override
	@Transactional
	public boolean createStudent(User student) {

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

		jdbc.update(
				"insert into users (name, username, password, rollnumber, mobile, enabled, image) values (:name, :username, :password, :rollnumber, :mobile, :enabled, :image)",
				params);
		return jdbc
				.update("insert into authorities (username, authority) values (:username, :authority)",
						params) == 1;
	}
	
	@Override
	public List<User> getAllStudents() {

		return jdbc
				.query("select * from users, authorities where users.username = authorities.username AND authorities.authority='ROLE_STUDENT'",
						new RowMapper<User>() {

							@Override
							public User mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								User user = new User();

								user.setName(rs.getString("name"));
								user.setUsername(rs.getString("username"));
								user.setPassword(rs.getString("password"));
								user.setRollnumber(rs.getString("rollnumber"));
								user.setMobile(rs.getString("mobile"));
								user.setEnabled(rs.getInt("enabled"));
								 
								return user;
							}
						});

	}

	

	@Override
	public boolean exists(String username) {
		return jdbc.queryForObject(
				"select count(*) from users where username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}


	@Override
	public boolean deleteStudent(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User updateStudent(User student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getStudent(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
