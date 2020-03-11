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

import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.domain.Course;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.util.ConnectionUtil;
import com.swaathi.courseapp.util.ErrorConstant;

@Repository
public class CourseDAOImpl implements CourseDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(CourseDAOImpl.class);

	public void save(Course course) throws DBException {
		String sql = "insert into courses (course_code,course_name,course_fee,course_duration_days,pre_req) values(?,?,?,?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, course.getCourseCode());
			pst.setString(2, course.getCourseName());
			pst.setInt(3, course.getCourseFee());
			pst.setInt(4, course.getCourseDurationDays());
			pst.setString(5, course.getPreReq());
			int rows = pst.executeUpdate();
			Logger.info("No of rows inserted : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}

	}

	public void update(int courseCode, int courseDurationDays) throws DBException {
		String sql = "update courses set course_duration_days=? where course_code=?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, courseDurationDays);
			pst.setInt(2, courseCode);
			int rows = pst.executeUpdate();
			Logger.info("No of rows Updated : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}

	}

	public void delete(int courseCode) throws DBException {
		String sql = "delete from courses where course_code=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, courseCode);
			int rows = pst.executeUpdate();
			Logger.info("No of rows deleted : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_DELETE);
		}
	}

	public List<Course> findAll() throws DBException {

		List<Course> c = new ArrayList<>();
		String sql = "select course_name,course_code,course_fee,course_duration_days,pre_req,course_image from courses";

		try (Connection connection = ConnectionUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				String cName = rs.getString("course_name");
				int courseCode = rs.getInt("course_code");
				int courseFee = rs.getInt("course_fee");
				int courseDurationDays = rs.getInt("course_duration_days");
				String preReq = rs.getString("pre_req");
				String courseImage = rs.getString("course_image");

				Course course = new Course();
				course.setCourseName(cName);
				course.setCourseCode(courseCode);
				course.setCourseFee(courseFee);
				course.setCourseDurationDays(courseDurationDays);
				course.setPreReq(preReq);
				course.setCourse_image(courseImage);
				c.add(course);
			}
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return c;
	}

	@Override
	public List<Course> findByCourseName(String courseName) throws DBException {
		List<Course> list = new ArrayList<>();
		String sql = "select course_code,course_name,course_fee,course_duration_days,pre_req from courses where course_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, courseName);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					String courseName1 = rs.getString("course_name");
					Logger.debug(courseName1);
					int courseFee = rs.getInt("course_fee");
					Logger.debug("CourseFee" + courseFee);
					int courseDurationDays = rs.getInt("course_duration_days");
					Logger.debug("CourseDurationDays" + courseDurationDays);
					String preReq = rs.getString("pre_Req");
					Logger.debug("PreRequisite" + preReq);
					int courseCode = rs.getInt("course_code");
					Logger.debug("CourseCode" + courseCode);
					Course course = new Course();
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
		int courseFee = 0;
		List<Course> list = new ArrayList<>();
		String sql = "select course_fee from courses where course_code=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, courseCode);
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					courseFee = rs.getInt("course_fee");
					Logger.debug("CourseFee" + courseFee);
					Course course = new Course();
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
