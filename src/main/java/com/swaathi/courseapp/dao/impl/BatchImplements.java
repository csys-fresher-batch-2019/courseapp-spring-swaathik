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

import com.swaathi.courseapp.controller.IndexController;
import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.domain.BatchClass;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.exception.ErrorConstant;
import com.swaathi.courseapp.util.ConnectionUtil;


@Repository
public class BatchImplements implements BatchDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);
	public void save(BatchClass batch) throws DBException {
		String sql = "insert into Batches(batch_code,course_code,course_name,starting_date,end_date) values(?,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, batch.getBatchCode());
			pst.setInt(2, batch.getCourseCode());
			pst.setString(3, batch.getCourseName());
			Date startDate = Date.valueOf(batch.getStartingDate());
			pst.setDate(4,startDate);
			pst.setDate(5, Date.valueOf(batch.getEndDate()));
			int rows = pst.executeUpdate();
			Logger.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}
	public void delete(int batchCode) throws DBException {
		String sql = "delete from batches where batch_code = ?";
		try (Connection connection = ConnectionUtil.getConnection(); PreparedStatement pst = connection.prepareStatement(sql);)		
		{
			pst.setInt(1,batchCode);
			int rows = pst.executeUpdate();
			Logger.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_DELETE);
			
		}
	}
	public void update(int courseCode) throws DBException {
		String sql = "update batches set batch_code=121 where course_code=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,courseCode);
			Logger.info(sql);
			int rows = pst.executeUpdate();
			Logger.info("No of rows updated : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}
		

	public List<BatchClass> findByCourseName(String courseName) throws SQLException, DBException {
		List<BatchClass> b = new ArrayList<>();
		String sql = "select batch_code,starting_date,end_date from batches where course_name=?";
		try(Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)){
						pst.setString(1, courseName);
				try(ResultSet rs = pst.executeQuery()){
			while (rs.next()) {
				int batchCode = rs.getInt("batch_code");
				LocalDate startingDate = rs.getDate("starting_date").toLocalDate();
				LocalDate endDate = rs.getDate("end_date").toLocalDate();
				Logger.info("Batch Code : "+batchCode+" "+"Starting Date : "+startingDate+"End Date : "+endDate);
				BatchClass batch = new BatchClass();
				batch.setBatchCode(batchCode);
				batch.setStartingDate(startingDate);
				batch.setEndDate(endDate);
				b.add(batch);
			}
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return b;
}
	}
		public List<BatchClass> findAll() throws DBException {
			List<BatchClass> r = new ArrayList<>();
			String sql = "select batch_code,course_code,course_name,starting_date,end_date from batches";
			try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					int batchCode = rs.getInt("batch_code");
					int courseCode = rs.getInt("course_code");
					String courseName = rs.getString("course_name");
					LocalDate startingDate = rs.getDate("starting_date").toLocalDate();
					LocalDate endDate = rs.getDate("end_date").toLocalDate();
					Logger.info("Batch Code : "+batchCode+" "+"Starting Date : "+startingDate+"End Date : "+endDate+"CourseCode : "+courseCode+"CourseName : "+courseName);
					BatchClass batch = new BatchClass();
					batch.setBatchCode(batchCode);
					batch.setStartingDate(startingDate);
					batch.setEndDate(endDate);
					batch.setCourseCode(courseCode);
					batch.setCourseName(courseName);
					r.add(batch);
				}
			} catch (Exception e) {
				Logger.debug(e.getMessage());
				throw new DBException(ErrorConstant.INVALID_SELECT);
			}
			return r;
	}
}