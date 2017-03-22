package com.sbbusba.ecampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbbusba.ecampus.dao.AttendanceDao;
import com.sbbusba.ecampus.dao.AttendanceDaoImp;
import com.sbbusba.ecampus.model.Attendance;

@Service("attendanceService")
@Repository
@Transactional
public class AttendanceService implements AttendanceServiceInterface {
 
	AttendanceDao attendanceDaoImp;
	
	@Autowired
	public void setAttendanceDaoImp(AttendanceDao attendanceDaoImp) {
		this.attendanceDaoImp = attendanceDaoImp;
	}
 
	
	@Override
 	public void createAttendance(Attendance attendance) {
		 attendanceDaoImp.createAttendance(attendance);

	}

	
	 
}
