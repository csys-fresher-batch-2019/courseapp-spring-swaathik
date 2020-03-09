package com.swaathi.courseapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swaathi.courseapp.controller.IndexController;
import com.swaathi.courseapp.dao.enrollmentDAO;
import com.swaathi.courseapp.domain.enrollmentClass;
import com.swaathi.courseapp.util.ConnectionUtil;


@Repository
public class enrollmentImplements implements enrollmentDAO {

	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);
	public List<enrollmentClass> displayEnrollStud() {
		List<enrollmentClass> c = new ArrayList<>();
		String sql = "select pay_type,stud_user_name,course_name from enroll_stud";
		
		
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				String payType = rs.getString("pay_type");
				Logger.debug("Payment Type : "+payType);
				
				String UserName = rs.getString("stud_user_name");
				Logger.debug("UserName: "+UserName);
				String courseName = rs.getString("course_name");
				Logger.debug("Course Name : "+courseName);
				
				enrollmentClass enroll = new enrollmentClass();
				enroll.setPayType(payType);
				enroll.setUserName(UserName);
				enroll.setCourseName(courseName);
				c.add(enroll);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			Logger.debug(e.getMessage());
		}
		return c;
	}
	
	public void addEnrollement(enrollmentClass enroll) {
			String sql = "insert into enroll_stud (pay_type,stud_user_name,course_name) values(?,?,?)";
			try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
				pst.setString(1,enroll.getPayType());
				pst.setString(2,enroll.getUserName());
				pst.setString(3,enroll.getCourseName());
				int rows = pst.executeUpdate();
				Logger.info("No of rows inserted : "+rows);
			} catch (Exception e) {
				e.printStackTrace();
				Logger.debug(e.getMessage());
			}
			
		}
		
	}

