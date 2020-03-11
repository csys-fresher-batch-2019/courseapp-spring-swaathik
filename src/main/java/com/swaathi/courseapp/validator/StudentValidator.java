package com.swaathi.courseapp.validator;

import com.swaathi.courseapp.domain.Batch;
import com.swaathi.courseapp.domain.Course;
import com.swaathi.courseapp.domain.Student;
import com.swaathi.courseapp.exception.ValidatorException;

public class StudentValidator {
	public static void validateRegisterForm(Student u) throws ValidatorException {
		if (u.getFullName() == null || "".equals(u.getFullName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if (u.getFatherNameOrGuardianName() == null || "".equals(u.getFatherNameOrGuardianName().trim())) {
			throw new ValidatorException("FatherName cannot be blank/empty");
		}
		if (u.getPassWord() == null || "".equals(u.getPassWord().trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
		if (u.getUserName() == null || "".equals(u.getUserName().trim())) {
			throw new ValidatorException("UserName cannot be blank/empty");
		}
		if (u.getEmailId() == null || "".equals(u.getEmailId().trim())) {
			throw new ValidatorException("Mail-id cannot be blank/empty");
		}
		if (u.getPhoneNo() == null || "".equals(u.getPhoneNo().trim())) {
			throw new ValidatorException("Phone-number cannot be blank/empty");
		}
	}

	public static void validateCourseForm(Course c) throws ValidatorException {
		if (c.getCourseCode() == 0) {
			throw new ValidatorException("CourseCode cannot be blank/empty");
		}
		if (c.getCourseName() == null || "".equals(c.getCourseName().trim())) {
			throw new ValidatorException("CourseName cannot be blank/empty");
		}
		if (c.getCourseDurationDays() == 0) {
			throw new ValidatorException("CourseDuration cannot be blank/empty");
		}
		if (c.getCourseFee() == 0) {
			throw new ValidatorException("CourseFee cannot be blank/empty");
		}

	}

	public static void validateBatchForm(Batch b) throws ValidatorException {
		if (b.getBatchCode() == 0) {
			throw new ValidatorException("BatchCode cannot be blank/empty");
		}
		if (b.getCourseName() == null || "".equals(b.getCourseName().trim())) {
			throw new ValidatorException("CourseName cannot be blank/empty");
		}
		if (b.getCourseCode() == 0) {
			throw new ValidatorException("CourseCode cannot be blank/empty");
		}
	}
}
