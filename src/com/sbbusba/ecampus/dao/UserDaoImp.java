package com.sbbusba.ecampus.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("userDaoImp")
public class UserDaoImp {
	
	private NamedParameterJdbcTemplate jdbc;
 
	
	@Autowired
	private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

	@Autowired
 	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<User> getStudents(){
		
		return jdbc.query("select * from users, authorities where users.username = authorities.username AND authorities.authority='ROLE_STUDENT'", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
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

	@Transactional
	public boolean createStudent(User student) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", student.getName());
		params.addValue("username", student.getUsername());
		params.addValue("password", passwordEncoder.encode(student.getPassword()));
		
		params.addValue("rollnumber", student.getRollnumber());
		params.addValue("mobile", student.getMobile());
		params.addValue("enabled", student.getEnabled());
		params.addValue("authority", student.getAuthority());
		
		 
 		
		jdbc.update("insert into users (name, username, password, rollnumber, mobile, enabled) values (:name, :username, :password, :rollnumber, :mobile, :enabled)", params);
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
	}

	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	public List<User> getUsers() {
		
		return jdbc.query("select * from users,authorities where users.username=authorities.username", BeanPropertyRowMapper.newInstance(User.class));
	}

	

	}
	
 
