package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.enrollmentClass;


public interface enrollmentDAO {
	
	void addEnrollement(enrollmentClass enroll) ;
	
	List<enrollmentClass> displayEnrollStud();

}
