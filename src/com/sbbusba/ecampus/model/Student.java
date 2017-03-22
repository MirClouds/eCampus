package com.sbbusba.ecampus.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 5362437768854142524L;

	@Id
	@Column(name = "student_id")
	private int student_id;

	@NotBlank(message = "Username cannot be blank.")
	@Size(min = 5, max = 15, message = "Username must be between 8 and 15 characters long.")
	@Pattern(regexp = "^\\w{8,}$", message = "Username can only consist of numbers, letters and the underscore character.")
	@Column(name = "username")
	private String username;

	@Column(name = "name")
	private String name;

	@NotBlank(message = "password cannot be blank.")
	@Column(name = "password")
	private String password;
	private String rollnumber;
	private String mobile;

	private String image;
	private int enabled;

	private String authority;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "semester_id")
	public Semester semester;

	public Student() {
	}

	public Student(int student_id, String username, String name,
			String password, String rollnumber, String mobile, String image,
			int enabled, String authority, Semester semester) {
		super();
		this.student_id = student_id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.rollnumber = rollnumber;
		this.mobile = mobile;
		this.image = image;
		this.enabled = enabled;
		this.authority = authority;
		this.semester = semester;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

/*	public int getSemester_id() {
		return semester.semester_id;
	}*/

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", username=" + username
				+ ", name=" + name + ", password=" + password + ", rollnumber="
				+ rollnumber + ", mobile=" + mobile + ", image=" + image
				+ ", enabled=" + enabled + ", authority=" + authority
				+ ", semester=" + semester + "]";
	}

}
