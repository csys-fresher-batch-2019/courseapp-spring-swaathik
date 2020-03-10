package com.swaathi.courseapp.domain;

import java.time.LocalDate;

import com.swaathi.courseapp.util.Logger;

public class StudentClass {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + admNo;
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((fatherNameOrGuardianName == null) ? 0 : fatherNameOrGuardianName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentClass other = (StudentClass) obj;
		if (admNo != other.admNo)
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (fatherNameOrGuardianName == null) {
			if (other.fatherNameOrGuardianName != null)
				return false;
		} else if (!fatherNameOrGuardianName.equals(other.fatherNameOrGuardianName))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public String getFatherNameOrGuardianName() {
		return fatherNameOrGuardianName;
	}

	private static final Logger LOGGER = Logger.getInstance();
	private int admNo;
	private String fullName;
	private String fatherNameOrGuardianName;
	private String emailId;
	private String phoneNo;
	private String userName;
	private String passWord;
	private LocalDate dateOfJoining;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public int getAdmNo() {
		return admNo;
	}

	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String string() {
		return fatherNameOrGuardianName;
	}

	public void setFatherNameOrGuardianName(String fatherNameOrGuardianName) {
		this.fatherNameOrGuardianName = fatherNameOrGuardianName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate doj) {
		this.dateOfJoining = doj;
	}

	public void setPhoneNo(String phoneNo) {
		if (phoneNo.length() < 10 || phoneNo.length() > 10)
			throw new IllegalArgumentException("Invalid Phone Number!!!");
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "StudentClass [ fullName=" + fullName + ", fatherNameOrGuardianName=" + fatherNameOrGuardianName
				+ ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", dateOfJoining=" + dateOfJoining + "]";
	}
}
