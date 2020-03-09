package com.swaathi.courseapp.dao;

import java.util.List;

import com.swaathi.courseapp.domain.PaymentClass;
import com.swaathi.courseapp.exception.DBException;

public interface PaymentDAO {

	void addPayments(PaymentClass payment) throws DBException ;
	
	void updatePayments(int receiptNo) throws DBException;
	
	List<PaymentClass> displayAmountPaid () throws DBException;
	
	List<PaymentClass> displayEnroll()throws DBException;	
	void deletePayments(int receiptNo)throws DBException;
	
}
