package com.swaathi.courseapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.swaathi.courseapp.domain.BatchClass;
import com.swaathi.courseapp.exception.DBException;

public interface BatchDAO {
	
	
	void addBatches(BatchClass batch) throws DBException;
	

	List<BatchClass>displayBatchCodeCourseCode(String courseName) throws SQLException, DBException ;
	
	List<BatchClass> displayBatches() throws DBException;
	
	void deleteBatches (int batchCode) throws DBException;
	
	void updateBatches(int receiptNo) throws DBException ;
	

}
