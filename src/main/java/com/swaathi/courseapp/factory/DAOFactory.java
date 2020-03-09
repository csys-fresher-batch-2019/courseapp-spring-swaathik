package com.swaathi.courseapp.factory;

import org.springframework.stereotype.Component;

import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.dao.PaymentDAO;
import com.swaathi.courseapp.dao.StudentDAO;
import com.swaathi.courseapp.dao.enrollmentDAO;
import com.swaathi.courseapp.dao.impl.BatchImplements;
import com.swaathi.courseapp.dao.impl.CourseImplements;
import com.swaathi.courseapp.dao.impl.PaymentImplements;
import com.swaathi.courseapp.dao.impl.StudentImplementation;
import com.swaathi.courseapp.dao.impl.enrollmentImplements;
@Component
public class DAOFactory {

public static CourseDAO getCourseDAO() {
	return new CourseImplements();
}
public static BatchDAO getBatchDAO() {
	return new BatchImplements();
}
public static StudentDAO getStudentDAO() { 
	return new StudentImplementation();
}
public static PaymentDAO getPaymentDAO() {
	return  new PaymentImplements();
}
public static enrollmentDAO getenrollmentDAO() {
	return  new enrollmentImplements();
}

}
