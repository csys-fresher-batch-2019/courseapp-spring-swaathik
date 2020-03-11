package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.Student;
import com.swaathi.courseapp.exception.DBException;

public interface StudentDAO {
	int save(Student student) throws DBException;

	void update(int admNo, String emailID) throws DBException;

	List<Student> findAll() throws DBException;

	void delete(int admissionNo) throws DBException;

	int findByUserNameAndPassword(String userName, String passWord) throws DBException;

}
