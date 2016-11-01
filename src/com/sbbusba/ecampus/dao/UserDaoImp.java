package com.sbbusba.ecampus.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sbbusba.ecampus.model.User;

@Component("userDaoImp")
@Repository
public class UserDaoImp implements UserDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public UserDaoImp() {
        System.out.println("Working UserDaoImp");
    }
	
 
	@Autowired  
	 private SessionFactory sessionFactory;  
	  
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 } 

	@Autowired
	private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<User> getAllUser() {

		return jdbc
				.query("select * from users,authorities where users.username=authorities.username",
						BeanPropertyRowMapper.newInstance(User.class));
	}

	@Override
	public String createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
 
	  @Override
	    public void deleteUser(String username) {
		  Session session = this.sessionFactory.getCurrentSession();  
		  User p = (User) session.load(User.class, new String(username));  
		  if (null != p) {  
		   session.delete(p);

		 }}
 

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public User getUser(String username) {
		 Session session = this.sessionFactory.getCurrentSession();  
		  User user= (User) session.load(User.class, new String(username));  
		  return user;  
	}*/
	
	  @Override
	    @SuppressWarnings("unchecked")
	    public User getUser(String username) {
	        Session session = sessionFactory.getCurrentSession();
	        List<User> list = session.createQuery("from users u where u.username = :username")
	            .setParameter("username", username)
	            .list();
	        return list.size() > 0 ?(Book)list.get(0): null;
	    }

}
