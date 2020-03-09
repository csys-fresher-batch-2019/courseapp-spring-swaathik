package com.swaathi.courseapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swaathi.courseapp.controller.IndexController;
import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.domain.CourseClass;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.exception.ErrorConstant;
import com.swaathi.courseapp.util.ConnectionUtil;

@Repository
public class CourseImplements implements CourseDAO{
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);
	public void save(CourseClass course) throws DBException {
		String sql = "insert into courses (course_code,course_name,course_fee,course_duration_days,pre_req) values(?,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, course.getCourseCode());
			pst.setString(2,course.getCourseName());
			pst.setInt(3, course.getCourseFee());
			pst.setInt(4, course.getCourseDurationDays());
			pst.setString(5, course.getPreReq());
			int rows = pst.executeUpdate();
			Logger.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
		
	}

	public void update(int courseCode) throws DBException  {
		String sql = "update courses set course_duration_days=45 where course_code=?";
		
		
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,courseCode);
			int rows = pst.executeUpdate();
			Logger.info("No of rows Updated : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
		
	}

	public void delete(int courseCode) throws DBException {
		String sql = "delete from courses where course_code=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,courseCode);
			int rows = pst.executeUpdate();
			Logger.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_DELETE);
		}
	}

	public List<CourseClass> findAll() throws DBException  {
		
		List<CourseClass> c = new ArrayList<>();
		String sql = "select course_name,course_code,course_fee,course_duration_days,pre_req,course_image from courses";
		
		
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				String cName = rs.getString("course_name");
				Logger.debug("Course Name : "+cName);
				int courseCode = rs.getInt("course_code");
				Logger.debug("Course Code : "+courseCode);
				int courseFee = rs.getInt("course_fee");
				Logger.debug("Course Fee : "+courseFee);
				int courseDurationDays = rs.getInt("course_duration_days");
				Logger.debug("Course Duration(days) : "+courseDurationDays);
				String preReq = rs.getString("pre_req");
				Logger.debug("Pre Requisite : "+preReq);
				String courseImage = rs.getString("course_image");
				Logger.debug("Course Image : "+courseImage);
				
				CourseClass course = new CourseClass();
				course.setCourseName(cName);
				course.setCourseCode(courseCode);
				course.setCourseFee(courseFee);
				course.setCourseDurationDays(courseDurationDays);
				course.setPreReq(preReq);
				course.setCourse_image(courseImage);
				c.add(course);
			}
		} 
		catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return c;
	}

	@Override
	public List<CourseClass> findByCourseName(String courseName) throws DBException  {
		List<CourseClass> list = new ArrayList<>();
		String sql = "select course_code,course_name,course_fee,course_duration_days,pre_req from courses where course_name=?";	
		try(Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql)){
		pst.setString(1, courseName);
		try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					String courseName1 = rs.getString("course_name");
					Logger.debug(courseName1);
					 int courseFee = rs.getInt("course_fee");
					Logger.debug("CourseFee"+courseFee);
					int courseDurationDays = rs.getInt("course_duration_days");
					Logger.debug("CourseDurationDays"+courseDurationDays);
					String preReq = rs.getString("pre_Req");
					Logger.debug("PreRequisite"+preReq);
					int courseCode = rs.getInt("course_code");
					Logger.debug("CourseCode"+courseCode);
					CourseClass course = new CourseClass();
					course.setCourseFee(courseFee);
					course.setCourseDurationDays(courseDurationDays);
					course.setPreReq(preReq);
					course.setCourseCode(courseCode);
					course.setCourseName(courseName1);
					list.add(course);
				}
		}
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
	  		return list;
	}

	public int findByCourseCode(int courseCode) throws DBException {
		int courseFee=0;
		List<CourseClass> list = new ArrayList<>();
		String sql = "select course_fee from courses where course_code=?";	
		try(Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql)){
		pst.setInt(1, courseCode);
		try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					 courseFee = rs.getInt("course_fee");
					Logger.debug("CourseFee"+courseFee);
					CourseClass course = new CourseClass();
					course.setCourseFee(courseFee);
					list.add(course);
				}
		}
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
	  		return courseFee;
	}
}
