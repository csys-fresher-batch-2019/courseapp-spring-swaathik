package com.swaathi.courseapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swaathi.courseapp.domain.Course;
import com.swaathi.courseapp.service.StudentService;

@SuppressWarnings("serial")
@WebServlet("/course")

public class CourseServlet extends HttpServlet {
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
		Course c1 = new Course();
		c1.setCourseFee(fee);
		c1.setCourseCode(code);
		c1.setCourseName(name);
		c1.setCourseDurationDays(days);
		c1.setPreReq(preReq);

		try {
			StudentService.course(c1);
			response.sendRedirect("ADD.jsp");

		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("CourseEnroll.jsp");
			dispatcher.forward(request, response);

		}

		HttpSession ses = request.getSession();
		ses.setAttribute("name", course);

	}
}