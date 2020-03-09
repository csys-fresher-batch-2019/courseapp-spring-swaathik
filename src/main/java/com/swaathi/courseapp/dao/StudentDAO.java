package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.StudentClass;
import com.swaathi.courseapp.exception.DBException;

public interface StudentDAO {
	 int addStudents(StudentClass student) throws DBException;
	 
	 void updateStudent(int admNo) throws DBException;

	List<StudentClass>displayStudents() throws DBException;
	void deleteStudent(int admNo) throws DBException ;
	
	int getUserId(String userName, String passWord)throws DBException;
	
}
