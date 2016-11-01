package com.sbbusba.ecampus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 5362437768854142524L;
	@NotBlank(message = "Username cannot be blank.")
	@Size(min = 8, max = 15, message = "Username must be between 8 and 15 characters long.")
	@Pattern(regexp = "^\\w{8,}$", message = "Username can only consist of numbers, letters and the underscore character.")
	@Id
	@Column(name = "username")
	private String username;

	@Size(min = 5, max = 17, message = "you must have 5 to 17 characters")
	@Column(name = "name")
	private String name;
	@Size(min = 5, max = 17, message = "you must have 5 to 17 characters")
	@Column(name = "rollnumber")
	private String rollnumber;

	private String password;
	private String mobile;

	private String image;
	private int enabled;
	
 
	private String authority;

	
	
 
	
	public User() {
	}

	public User(String username, String name, String rollnumber,
			String password, String mobile, String authority, String image,
			int enabled) {
		super();
		this.username = username;
		this.name = name;
		this.rollnumber = rollnumber;
		this.password = password;
		this.mobile = mobile;
		this.authority = authority;
		this.image = image;
		this.enabled = enabled;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name
				+ ", rollnumber=" + rollnumber + ", password=" + password
				+ ", mobile=" + mobile + ", authority=" + authority
				+ ", image=" + image + ", enabled=" + enabled + "]";
	}

}
