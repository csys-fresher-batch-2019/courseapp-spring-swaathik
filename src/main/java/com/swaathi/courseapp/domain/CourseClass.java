package com.swaathi.courseapp.domain;

public class CourseClass {
	private int courseCode;
	private String courseName;
	private int courseFee;
	private int courseDurationDays;
	private String preReq;
	private String course_image;

	public String getCourse_image() {
		return course_image;
	}

	public void setCourse_image(String course_image) {
		this.course_image = course_image;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		if (courseCode >= 10000)
			throw new IllegalArgumentException("Invalid Course Code!!!");
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public int getCourseDurationDays() {
		return courseDurationDays;
	}

	public void setCourseDurationDays(int courseDurationDays) {
		this.courseDurationDays = courseDurationDays;
	}

	public String getPreReq() {
		return preReq;
	}

	public void setPreReq(String preReq) {
		this.preReq = preReq;
	}

	/////
	@Override
	public String toString() {
		return "CourseClass [courseCode=" + courseCode + ", courseName=" + courseName + ", courseFee=" + courseFee
				+ ", courseDurationDays=" + courseDurationDays + ", preReq=" + preReq + ", course_image=" + course_image
				+ "]";
	}

}
