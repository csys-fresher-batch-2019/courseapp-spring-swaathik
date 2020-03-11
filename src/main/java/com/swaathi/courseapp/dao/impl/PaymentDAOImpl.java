package com.swaathi.courseapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swaathi.courseapp.dao.PaymentDAO;
import com.swaathi.courseapp.domain.Payment;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.util.ConnectionUtil;
import com.swaathi.courseapp.util.ErrorConstant;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(PaymentDAOImpl.class);

	public void save(Payment payment) throws DBException {
		String sql = "insert into payments(receipt_no,adm_no,amount_paid,remarks) values(receipt_no_sq.nextval,?,?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, payment.getAdmNo());
			pst.setInt(2, payment.getAmountPaid());
			pst.setString(3, payment.getReMarks());
			int rows = pst.executeUpdate();
			Logger.info("No of rows inserted : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
	}

	public void update(int receiptNo, String reMarks) throws DBException {
		String sql = "update payments set remarks=? where receipt_no=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, reMarks);
			pst.setInt(2, receiptNo);
			int rows = pst.executeUpdate();
			Logger.info("No of rows Updated : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}

	public List<Payment> findAll() throws DBException {
		List<Payment> p = new ArrayList<>();
		String sql = "select receipt_no,adm_no,amount_paid,remarks,pay_date from payments";
		try (Connection connection = ConnectionUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				int receiptNo = rs.getInt("receipt_no");
				int amountPaid = rs.getInt("adm_no");
				int admNo = rs.getInt("amount_paid");
				String reMarks = rs.getString("remarks");
				LocalDateTime payDate = rs.getTimestamp("pay_date").toLocalDateTime();

				Payment payment = new Payment();

				payment.setReceiptNo(receiptNo);
				payment.setAmountPaid(amountPaid);
				payment.setAdmNo(admNo);
				payment.setPayDate(payDate);
				payment.setReMarks(reMarks);
				Logger.debug(receiptNo + " " + amountPaid + " " + admNo + " " + reMarks + " " + payDate);
				p.add(payment);
			}
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return p;
	}

	public void delete(int receiptNo) throws DBException {
		String sql = "update payments set active = 0 where receipt_no=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, receiptNo);
			int rows = pst.executeUpdate();
			Logger.info("No of rows deleted : " + rows);
		} catch (SQLException e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}
}