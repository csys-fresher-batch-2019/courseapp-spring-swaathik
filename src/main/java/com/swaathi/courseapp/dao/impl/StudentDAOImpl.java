package com.swaathi.courseapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swaathi.courseapp.dao.StudentDAO;
import com.swaathi.courseapp.domain.Student;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.util.ConnectionUtil;
import com.swaathi.courseapp.util.ErrorConstant;

@Repository
public class StudentDAOImpl implements StudentDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	public int save(Student student) throws DBException {
		int rows = 0;
		String sql = "insert into students(adm_no,full_name,father_name_or_guardian_name,email_id,phone_no,date_of_joining,stud_user_name,stud_password)values(adm_no_sq.nextval,?,?,?,?,?,?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, student.getFullName());
			pst.setString(2, student.getFatherNameOrGuardianName());
			pst.setString(3, student.getEmailId());
			pst.setString(4, student.getPhoneNo());
			pst.setDate(5, Date.valueOf(student.getDateOfJoining()));
			pst.setString(6, student.getUserName());
			pst.setString(7, student.getPassWord());
			rows = pst.executeUpdate();
			Logger.info("No of rows inserted : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
		return rows;
	}

	public void update(int admissionNo, String emailId) throws DBException {
		String sql = "update Students set email_id = ? where adm_no=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, emailId);
			pst.setInt(2, admissionNo);
			int rows = pst.executeUpdate();
			Logger.info("No of rows updated : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}

	public void delete(int admNo) throws DBException {
		String sql = "update Students set student_active = 0 where adm_no=?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, admNo);
			int rows = pst.executeUpdate();
			Logger.info("No of rows deleted : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}

	}

	public List<Student> findAll() throws DBException {
		List<Student> c = new ArrayList<>();
		String sql = "select adm_no,full_name,father_name_or_guardian_name,email_id,phone_no,date_of_joining,stud_user_name from students";
		try (Connection connection = ConnectionUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int admNo = rs.getInt("adm_no");
				Logger.debug("Admission Number : " + admNo);
				String fullName = rs.getString("full_name");
				Logger.debug("Full Name : " + fullName);
				String fatherNameOrGuardianName = rs.getString("father_name_or_guardian_name");
				Logger.debug("FatherName Or GuardianName : " + fatherNameOrGuardianName);
				String username = rs.getString("stud_user_name");
				Logger.debug("User Name : " + username);
				String emailId = rs.getString("email_id");
				Logger.debug("Email Id : " + emailId);
				String phoneNo = rs.getString("phone_No");
				Logger.debug("Phone Number : " + phoneNo);
				LocalDate dateOfJoining = rs.getDate("date_of_joining").toLocalDate();
				Logger.debug("DateOfJoining : " + dateOfJoining);

				Student student = new Student();
				student.setAdmNo(admNo);
				student.setFullName(fullName);
				student.setFatherNameOrGuardianName(fatherNameOrGuardianName);
				student.setEmailId(emailId);
				student.setDateOfJoining(dateOfJoining);
				student.setPhoneNo(phoneNo);
				student.setUserName(username);
				c.add(student);
			}
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return c;
	}

	public int findByUserNameAndPassword(String userName, String passWord) throws DBException {
		String sql = "select adm_no from students where stud_user_name=?and stud_password=?";
		System.out.println(sql);
		int v = 0;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, userName);
			pst.setString(2, passWord);

			try (ResultSet row = pst.executeQuery()) {
				if (row.next()) {
					v = row.getInt("adm_no");

				}
			}
		} catch (SQLException e) {
			Logger.error(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return v;

	}

}
