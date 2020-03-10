package com.swaathi.courseapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.swaathi.courseapp.domain.BatchClass;
import com.swaathi.courseapp.exception.DBException;

public interface BatchDAO {

	void save(BatchClass batch) throws DBException;

	List<BatchClass> findByCourseName(String courseName) throws SQLException, DBException;

	List<BatchClass> findAll() throws DBException;

	void delete(int batchCode) throws DBException;

	void update(int batchCode, int CourseCode) throws DBException;

}
