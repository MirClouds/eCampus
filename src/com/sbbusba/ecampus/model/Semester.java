package com.sbbusba.ecampus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
 
@Entity
@Table(name = "semester")
public class Semester implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "semester_id")
	public int semester_id;

	@Column(name = "semester_name")
	private String semester_name;

	@Column(name = "desc")
	private String desc;
	
   @OneToMany (mappedBy = "semester")
   @Cascade(value = { CascadeType.DELETE})
	private List <Student> student= new ArrayList<Student>();

	public Semester() {
	}

	 
	public Semester(int semester_id, String semester_name, String desc,
			List<Student> student) {
		super();
		this.semester_id = semester_id;
		this.semester_name = semester_name;
		this.desc = desc;
		this.student = student;
	}


	public int getSemester_id() {
		return semester_id;
	}

	public void setSemester_id(int semester_id) {
		this.semester_id = semester_id;
	}

	public String getSemester_name() {
		return semester_name;
	}

	public void setSemester_name(String semester_name) {
		this.semester_name = semester_name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Semester [semester_id=" + semester_id + ", semester_name="
				+ semester_name + ", desc=" + desc + "]";
	}

}
