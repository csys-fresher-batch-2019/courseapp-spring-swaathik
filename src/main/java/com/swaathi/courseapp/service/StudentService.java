package com.swaathi.courseapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Service;

import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.dao.StudentDAO;
import com.swaathi.courseapp.domain.Batch;
import com.swaathi.courseapp.domain.Course;
import com.swaathi.courseapp.domain.Student;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.exception.ServiceException;
import com.swaathi.courseapp.exception.ValidatorException;
import com.swaathi.courseapp.factory.DAOFactory;
import com.swaathi.courseapp.util.ConnectionUtil;
import com.swaathi.courseapp.util.ErrorConstant;
import com.swaathi.courseapp.util.Logger;
import com.swaathi.courseapp.validator.StudentValidator;

@Service
public class StudentService {
	private static final Logger LOGGER = Logger.getInstance();

	public static boolean login(Student user) {
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement stmt = con.prepareCall("{call login_procedure(?,?,?)}")) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassWord());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String status = stmt.getString(3);
			LOGGER.info("Status = " + status);
			if (status.equals("Success")) {
				LOGGER.debug("Logged In");
				return true;
			} else {
				LOGGER.debug("Logged out");
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
		return false;

	}

	public static void registration(Student u) throws ServiceException, DBException {
		StudentDAO dao = DAOFactory.getStudentDAO();
		try {
			System.out.println(u);
			StudentValidator.validateRegisterForm(u);
			dao.save(u);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	public static void course(Course c) throws ServiceException, DBException {
		CourseDAO dao = DAOFactory.getCourseDAO();
		try {
			System.out.println(c);
			StudentValidator.validateCourseForm(c);
			dao.save(c);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	public static void batch(Batch b) throws ServiceException, DBException {
		BatchDAO dao = DAOFactory.getBatchDAO();
		try {
			System.out.println(b);
			StudentValidator.validateBatchForm(b);
			dao.save(b);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} catch (DBException e) {
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}
}
