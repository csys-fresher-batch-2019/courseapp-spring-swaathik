package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.PaymentClass;
import com.swaathi.courseapp.exception.DBException;

public interface PaymentDAO {

	void save(PaymentClass payment) throws DBException;

	void update(int receiptNo, String reMarks) throws DBException;

	List<PaymentClass> findAll() throws DBException;

	void delete(int receiptNo) throws DBException;

}
