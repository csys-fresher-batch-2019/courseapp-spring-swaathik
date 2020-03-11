package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.Course;
import com.swaathi.courseapp.exception.DBException;

public interface CourseDAO {
	void save(Course course) throws DBException;

	void update(int courseCode, int courseDurationDays) throws DBException;

	void delete(int courseCode) throws DBException;

	List<Course> findAll() throws DBException;

	List<Course> findByCourseName(String courseName) throws DBException;

	int findByCourseCode(int courseCode) throws DBException;

}
