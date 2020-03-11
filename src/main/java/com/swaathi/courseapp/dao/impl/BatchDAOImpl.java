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
import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.domain.Batch;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.util.ConnectionUtil;
import com.swaathi.courseapp.util.ErrorConstant;

@Repository
public class BatchDAOImpl implements BatchDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(BatchDAOImpl.class);

	public void save(Batch batch) throws DBException {
		String sql = "insert into Batches(batch_code,course_code,course_name,starting_date,end_date) values(?,?,?,?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, batch.getBatchCode());
			pst.setInt(2, batch.getCourseCode());
			pst.setString(3, batch.getCourseName());
			Date startDate = Date.valueOf(batch.getStartingDate());
			pst.setDate(4, startDate);
			pst.setDate(5, Date.valueOf(batch.getEndDate()));
			int rows = pst.executeUpdate();
			Logger.info("No of rows inserted : " + rows);
		} catch (SQLException e) {

			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	public void delete(int batchCode) throws DBException {
		String sql = "delete from batches where batch_code = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, batchCode);
			int rows = pst.executeUpdate();
			Logger.info("No of rows deleted : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_DELETE);

		}
	}

	public void update(int courseCode, int batchCode) throws DBException {
		String sql = "update batches set batch_code=? where course_code=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, batchCode);
			pst.setInt(2, courseCode);
			Logger.info(sql);
			int rows = pst.executeUpdate();
			Logger.info("No of rows updated : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}

	public List<Batch> findByCourseName(String courseName) throws SQLException, DBException {
		List<Batch> b = new ArrayList<>();
		String sql = "select batch_code,starting_date,end_date from batches where course_name=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, courseName);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int batchCode = rs.getInt("batch_code");
					LocalDate startingDate = rs.getDate("starting_date").toLocalDate();
					LocalDate endDate = rs.getDate("end_date").toLocalDate();
					Logger.info("Batch Code : " + batchCode + " " + "Starting Date : " + startingDate + "End Date : "
							+ endDate);
					Batch batch = new Batch();
					batch.setBatchCode(batchCode);
					batch.setStartingDate(startingDate);
					batch.setEndDate(endDate);
					b.add(batch);
				}
			} catch (SQLException e) {
				Logger.debug(e.getMessage());
				throw new DBException(ErrorConstant.INVALID_SELECT);
			}
			return b;
		}
	}

	public List<Batch> findAll() throws DBException {
		List<Batch> r = new ArrayList<>();
		String sql = "select batch_code,course_code,course_name,starting_date,end_date from batches";
		try (Connection connection = ConnectionUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int batchCode = rs.getInt("batch_code");
				int courseCode = rs.getInt("course_code");
				String courseName = rs.getString("course_name");
				LocalDate startingDate = rs.getDate("starting_date").toLocalDate();
				LocalDate endDate = rs.getDate("end_date").toLocalDate();
				Logger.info("Batch Code : " + batchCode + " " + "Starting Date : " + startingDate + "End Date : "
						+ endDate + "CourseCode : " + courseCode + "CourseName : " + courseName);
				Batch batch = new Batch();
				batch.setBatchCode(batchCode);
				batch.setStartingDate(startingDate);
				batch.setEndDate(endDate);
				batch.setCourseCode(courseCode);
				batch.setCourseName(courseName);
				r.add(batch);
			}
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return r;
	}
}