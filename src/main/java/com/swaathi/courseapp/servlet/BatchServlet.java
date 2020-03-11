package com.swaathi.courseapp.servlet;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swaathi.courseapp.domain.Batch;

import com.swaathi.courseapp.service.StudentService;

@SuppressWarnings("serial")
@WebServlet("/batch")

public class BatchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String batch = request.getParameter("batchCode");
		int bCode = Integer.valueOf(batch);
		String course = request.getParameter("courseCode");
		int code = Integer.valueOf(course);
		String name = request.getParameter("courseName");
		String startingDate = request.getParameter("startingDate");
		LocalDate stDate = LocalDate.parse(startingDate);
		String endDate = request.getParameter("endDate");
		LocalDate enDate = LocalDate.parse(endDate);
		System.out.println("BatchCode : " + bCode);
		System.out.println("CourseName : " + name);
		System.out.println("CourseCode : " + code);
		System.out.println("StartingDate : " + stDate);
		System.out.println("EndDate : " + enDate);
		Batch b1 = new Batch();
		b1.setBatchCode(bCode);
		b1.setCourseName(name);
		b1.setCourseCode(code);
		b1.setStartingDate(stDate);
		b1.setEndDate(enDate);

		try {
			StudentService.batch(b1);
			response.sendRedirect("ADD.jsp");
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("BatchEnroll.jsp");
			dispatcher.forward(request, response);
		}

	}

}
