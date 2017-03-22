package com.sbbusba.ecampus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name = "attendance")
public class Attendance implements Serializable {

	private static final long serialVersionUID = 5362437768854142524L;

	@Id
	@Column(name = "att_id")
	private int att_id;

	
	@Column(name = "student_id")
	private int student_id;

	@Column(name = "sub_id")
	private int sub_id;

	@Column(name = "status")
	private int status;

	@Column(name = "date")
	private Date date;

	@Column(name = "start_time")
	private String start_time;

	@Column(name = "end_time")
	private String end_time;

	public Attendance() {
	}
	
	
	public Attendance(int att_id, int student_id, int sub_id, int status,
Date date, String start_time, String end_time) {
		super();
		this.att_id = att_id;
		this.student_id = student_id;
		this.sub_id = sub_id;
		this.status = status;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
	}


	public int getAtt_id() {
		return att_id;
	}

	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Attendance [att_id=" + att_id + ", student_id=" + student_id
				+ ", sub_id=" + sub_id + ", status=" + status + ", date="
				+ date + ", start_time=" + start_time + ", end_time="
				+ end_time + "]";
	}
	
	
	
 
}
