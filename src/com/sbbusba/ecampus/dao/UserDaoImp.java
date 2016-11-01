package com.sbbusba.ecampus.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sbbusba.ecampus.model.User;

@Component("userDaoImp")
@Repository
public class UserDaoImp implements UserDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public UserDaoImp() {
        System.out.println("Working UserDaoImp");
    }
	
 
	@Autowired  
	 private SessionFactory sessionFactory;  
	  
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 } 


	public List<User> getAllUser() {

		return jdbc
				.query("select * from users where authority != 'ROLE_ADMIN'",
						BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public boolean createUser(User student) {

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

		
		return jdbc.update(
				"insert into users (name, username, password, rollnumber, mobile, enabled, image, authority) values (:name, :username, :password, :rollnumber, :mobile, :enabled, :image, :authority)",
				params) == 1;
	}
	
 
	  @Override
	    public void deleteUser(String username) {
		  Session session = this.sessionFactory.getCurrentSession();  
		  User p = (User) session.load(User.class, new String(username));  
		  if (null != p) {  
		   session.delete(p);

		 }}
 

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	}
 
	  @Override
	    @SuppressWarnings("unchecked")
	    public User getUser(String username) {
	        Session session = sessionFactory.getCurrentSession();
	        List<User> list = session.createQuery("from User u where u.username = :username")
	            .setParameter("username", username)
	            .list();
	        return list.size() > 0 ?(User)list.get(0): null;
	    }
	  
	  @Override
		public boolean exists(String username) {
			return jdbc.queryForObject(
					"select count(*) from users where username=:username",
					new MapSqlParameterSource("username", username), Integer.class) > 0;
		}

}
