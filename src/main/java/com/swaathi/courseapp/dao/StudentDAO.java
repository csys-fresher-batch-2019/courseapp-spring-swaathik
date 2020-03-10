package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.StudentClass;
import com.swaathi.courseapp.exception.DBException;

public interface StudentDAO {
	int save(StudentClass student) throws DBException;

	void update(int admNo, String emailID) throws DBException;

	List<StudentClass> findAll() throws DBException;

	void delete(int admNo) throws DBException;

	int findByUserNameAndPassword(String userName, String passWord) throws DBException;

}
