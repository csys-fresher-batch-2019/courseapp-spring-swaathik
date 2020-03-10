package com.swaathi.courseapp.validator;

import com.swaathi.courseapp.domain.StudentClass;
import com.swaathi.courseapp.exception.ValidatorException;

public class Validator {
	public static void validateRegisterForm(StudentClass u) throws ValidatorException {
		if ( u.getUserName() == null || "".equals(u.getUserName().trim())) {
				throw new ValidatorException("Name cannot be blank/empty");
		}
		if(u.getEmailId() == null || "".equals(u.getEmailId().trim())) {
				throw new ValidatorException("Mail-id cannot be blank/empty");
		}
		if(u.getPassWord() == null || "".equals(u.getPassWord().trim())) {
				throw new ValidatorException("Password cannot be blank/empty");
		}
		if(u.getPhoneNo()== null ||"".equals(u.getPhoneNo().trim())) {
				throw new ValidatorException("Phone-number cannot be blank/empty");
		}
	}
}
