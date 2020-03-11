package com.swaathi.courseapp.factory;

import org.springframework.stereotype.Component;

import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.dao.PaymentDAO;
import com.swaathi.courseapp.dao.StudentDAO;
import com.swaathi.courseapp.dao.impl.BatchDAOImpl;
import com.swaathi.courseapp.dao.impl.CourseDAOImpl;
import com.swaathi.courseapp.dao.impl.PaymentDAOImpl;
import com.swaathi.courseapp.dao.impl.StudentDAOImpl;

@Component
public class DAOFactory {

	public static CourseDAO getCourseDAO() {
		return new CourseDAOImpl();
	}

	public static BatchDAO getBatchDAO() {
		return new BatchDAOImpl();
	}

	public static StudentDAO getStudentDAO() {
		return new StudentDAOImpl();
	}

	public static PaymentDAO getPaymentDAO() {
		return new PaymentDAOImpl();
	}

}
