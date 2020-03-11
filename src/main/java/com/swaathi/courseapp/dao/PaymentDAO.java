package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.Payment;
import com.swaathi.courseapp.exception.DBException;

public interface PaymentDAO {

	void save(Payment payment) throws DBException;

	void update(int receiptNo, String reMarks) throws DBException;

	List<Payment> findAll() throws DBException;

	void delete(int receiptNo) throws DBException;

}
