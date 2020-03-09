package com.swaathi.courseapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.domain.CourseClass;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.factory.DAOFactory;

@SuppressWarnings("serial")
@WebServlet("/course")

public class course extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String course = request.getParameter("courseCode");
		int code = Integer.valueOf(course);
		String name = request.getParameter("courseName");
		String fees = request.getParameter("courseFees");
		int fee = Integer.valueOf(fees);
		String duration = request.getParameter("courseDuration");
		int days = Integer.valueOf(duration);
		String preReq = request.getParameter("preReq");
		System.out.println("CourseName : " + name);
		System.out.println("CourseCode : " + code);
		System.out.println("CourseFees : " + fee);
		System.out.println("Duration : " + days);
		System.out.println("PreReq : " + preReq);
		CourseClass c1 = new CourseClass();
		c1.setCourseFee(fee);
		c1.setCourseCode(code);
		c1.setCourseName(name);
		c1.setCourseDurationDays(days);
		c1.setPreReq(preReq);
		// dao.enrollcourse
		CourseDAO dao = DAOFactory.getCourseDAO();
		try {
			dao.save(c1);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession ses = request.getSession();
		ses.setAttribute("name", course);
		response.sendRedirect("ADD.jsp");
		// forward - page - payment.jsp

	}
}