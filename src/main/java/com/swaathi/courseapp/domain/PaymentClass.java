package com.swaathi.courseapp.domain;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PaymentClass {
	private int receiptNo;
	private int admNo;
	private int amountPaid;
	private Timestamp payDate = Timestamp.valueOf(LocalDateTime.now());
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	private String reMarks;
	public int getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}
	public int getAdmNo() {
		return admNo;
	}
	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	public String getReMarks() {
		return reMarks;
	}
	public void setReMarks(String reMarks) {
		this.reMarks = reMarks;
	}
	
	

}
