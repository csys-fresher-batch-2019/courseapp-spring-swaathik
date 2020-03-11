package com.swaathi.courseapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.swaathi.courseapp.domain.Batch;
import com.swaathi.courseapp.exception.DBException;

public interface BatchDAO {

	void save(Batch batch) throws DBException;

	List<Batch> findByCourseName(String courseName) throws SQLException, DBException;

	List<Batch> findAll() throws DBException;

	void delete(int batchCode) throws DBException;

	void update(int batchCode, int CourseCode) throws DBException;

}
