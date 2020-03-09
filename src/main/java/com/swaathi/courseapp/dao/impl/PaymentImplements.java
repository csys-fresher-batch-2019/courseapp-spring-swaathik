package com.swaathi.courseapp.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swaathi.courseapp.controller.IndexController;
import com.swaathi.courseapp.dao.PaymentDAO;
import com.swaathi.courseapp.domain.PaymentClass;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.exception.ErrorConstant;
import com.swaathi.courseapp.util.ConnectionUtil;


@Repository
public class PaymentImplements implements PaymentDAO {
	private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(IndexController.class);
	public void addPayments(PaymentClass payment) throws DBException  {
		String sql = "insert into payments(receipt_no,adm_no,amount_paid,re_marks) values(receipt_no_sq.nextval,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,payment.getAdmNo());
			pst.setInt(2, payment.getAmountPaid());
			pst.setString(3, payment.getReMarks());
			int rows = pst.executeUpdate();
			Logger.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_ADD);
		}	
	}

	public void updatePayments(int receiptNo) throws DBException  {
		String sql = "update payments set re_marks='Cheque' where receipt_no=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,receiptNo);
			int rows = pst.executeUpdate();
			Logger.info("No of rows Updated : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}		
	}

	public List<PaymentClass> displayAmountPaid() throws DBException  {
		List<PaymentClass> p = new ArrayList<>();
		String sql = "select receipt_no,adm_no,amount_paid,re_marks,pay_date from payments";
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				int receiptNo = rs.getInt("receipt_no");
				int amountPaid = rs.getInt("adm_no");
			    int admNo = rs.getInt("amount_paid");
			    String reMarks = rs.getString("re_marks");
			    Timestamp payDate = rs.getTimestamp("pay_date");
			    
				PaymentClass payment = new PaymentClass();
				payment.setReceiptNo(receiptNo);
				payment.setAmountPaid(amountPaid);
				payment.setAdmNo(admNo);
				payment.setPayDate(payDate);
				payment.setReMarks(reMarks);
				Logger.debug(receiptNo+" "+amountPaid+" "+admNo+" "+reMarks+" "+payDate);
				p.add(payment);
			}
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return p;
	}

	public void deletePayments(int receiptNo) throws DBException  {
		String sql = "update payments set receipt_active = 0 where receipt_no=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,receiptNo);
			int rows = pst.executeUpdate();
			Logger.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}
	}

	@Override
	public List<PaymentClass> displayEnroll() throws DBException {
		List<PaymentClass> g = new ArrayList<>();
		String sql = "select receipt_no,adm_no,amount_paid,re_marks,pay_date from payments";
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				int receiptNo = rs.getInt("receipt_no");
				int amountPaid = rs.getInt("adm_no");
			    int admNo = rs.getInt("amount_paid");
			    String reMarks = rs.getString("re_marks");
			    Timestamp payDate = rs.getTimestamp("pay_date");
			    
				PaymentClass payment = new PaymentClass();
				payment.setReceiptNo(receiptNo);
				payment.setAmountPaid(amountPaid);
				payment.setAdmNo(admNo);
				payment.setPayDate(payDate);
				payment.setReMarks(reMarks);
				Logger.debug(receiptNo+" "+amountPaid+" "+admNo+" "+reMarks+" "+payDate);
				g.add(payment);
			}
		} catch (Exception e) {
			Logger.debug(e.getMessage());
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return g;
	}
	}