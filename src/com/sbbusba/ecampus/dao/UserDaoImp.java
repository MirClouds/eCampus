package com.sbbusba.ecampus.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * public void setSessionFactory(SessionFactory sf) { this.sessionFactory =
	 * sf; }
	 */

	/*
	 * //Get the list of current all users List list =
	 * getSession().createCriteria("you.pakcage.hibernate.Example")
	 * .add(Restrictions.ne("myProperty","blablabla")) .list()
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(Integer offset, Integer maxResults) {

		return sessionFactory.openSession().createCriteria(User.class)
				.setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 10)
				.add(Restrictions.ne("authority", "ROLE_ADMIN")).list();
	}

	// add user
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

		return jdbc
				.update("insert into users (name, username, password, rollnumber, mobile, enabled, image, authority) values (:name, :username, :password, :rollnumber, :mobile, :enabled, :image, :authority)",
						params) == 1;

	}

	// delete record
	@Override
	public void deleteUser(int user_id) {
		User user = getUser(user_id);
		if (user != null)
			getCurrentSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	/*
	 * public User getUser(String username) { Session session =
	 * sessionFactory.getCurrentSession(); List<User> list = session
	 * .createQuery("from User u where u.username = :username")
	 * .setParameter("username", username).list(); return list.size() > 0 ?
	 * (User) list.get(0) : null; }
	 */
	public User getUser(int user_id) {
		User user = (User) getCurrentSession().get(User.class, user_id);
		return user;
	}

	@Override
	public boolean exists(String username) {
		return jdbc
				.queryForObject(
						"select count(*) from student, users where student.username=:username OR users.username=:username",
						new MapSqlParameterSource("username", username),
						Integer.class) > 0;

	}

	@Override
	public Long count() {
		return (Long) sessionFactory.openSession().createCriteria(User.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

}
