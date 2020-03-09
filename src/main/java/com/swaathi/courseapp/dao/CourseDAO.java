package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.CourseClass;
import com.swaathi.courseapp.exception.DBException;

public interface CourseDAO {
	void addCourses(CourseClass course) throws DBException ;
	
	void updateCourses(int courseCode) throws DBException ;
	
	void deleteCourses(int courseCode) throws DBException ;
	
	List<CourseClass> orderByCourseName() throws DBException;
	 
	List<CourseClass> orderBy(String courseName) throws DBException ;
  
	int getCourseFee(int courseCode) throws DBException;
	
}
