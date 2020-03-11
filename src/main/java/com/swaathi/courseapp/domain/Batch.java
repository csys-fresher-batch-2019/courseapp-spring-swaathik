package com.swaathi.courseapp.domain;

import java.time.LocalDate;

public class Batch {
	private int batchCode;
	private int courseCode;
	private String courseName;
	private LocalDate startingDate;
	private LocalDate endDate;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName2) {
		this.courseName = courseName2;
	}

	public int getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(int batchCode) {
		if (batchCode >= 10000) {
			throw new IllegalArgumentException("Invalid Batch Code!!!");
		}
		this.batchCode = batchCode;

	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Batches [batchCode=" + batchCode + ", courseCode=" + courseCode + ", courseName=" + courseName
				+ ", startingDate=" + startingDate + ", endDate=" + endDate + "]";
	}
}
