package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.CourseClass;
import com.swaathi.courseapp.exception.DBException;

public interface CourseDAO {
	void save(CourseClass course) throws DBException;

	void update(int courseCode, int courseDurationDays) throws DBException;

	void delete(int courseCode) throws DBException;

	List<CourseClass> findAll() throws DBException;

	List<CourseClass> findByCourseName(String courseName) throws DBException;

	int findByCourseCode(int courseCode) throws DBException;

}
