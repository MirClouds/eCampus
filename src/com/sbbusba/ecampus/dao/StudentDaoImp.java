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

import com.sbbusba.ecampus.model.Student;

@Component("studentDaoImp")
@Repository
public class StudentDaoImp implements StudentDao {

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

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent(Integer offset, Integer maxResults) {

		/*
		 * return getCurrentSession()
		 * .createCriteria("com.sbbusba.ecampus.model.Student")
		 * .add(Restrictions.ne("authority", "ROLE_ADMIN")).list();
		 */
		// return getCurrentSession().createQuery("from Student").list();

		return sessionFactory.openSession().createCriteria(Student.class)
				
				.setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 10).list();

	}

	// add user
	@Override
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
	}

	// delete record
	@Override
	public void deleteStudent(String username) {
		Student student = getStudent(username);
		if (student != null)
			getCurrentSession().delete(student);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(student);
	}

	@Override
	public Student getStudent(String username) {
		Student student = (Student) getCurrentSession().get(Student.class,
				username);
		return student;
	}

	@Override
	public boolean existsStudent(String username) {
		return jdbc.queryForObject(
				"select count(*) from student, users where student.username=:username OR users.username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	@Override
	public Long count() {
		return (Long) sessionFactory.openSession()
				.createCriteria(Student.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

}
