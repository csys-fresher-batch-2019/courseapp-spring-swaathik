package com.swaathi.courseapp.servlet;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.domain.BatchClass;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.factory.DAOFactory;
@SuppressWarnings("serial")
@WebServlet("/batch")

public class batch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String batch = request.getParameter("batchCode");
		        int bCode = Integer.valueOf(batch);
				String course = request.getParameter("courseCode");
				int code = Integer.valueOf(course);
				String name = request.getParameter("courseName");
				String startingDate = request.getParameter("startingDate");
				LocalDate stDate =LocalDate.parse(startingDate);
				String endDate = request.getParameter("endDate");
				LocalDate enDate =LocalDate.parse(endDate);
				System.out.println("BatchCode : "+bCode);
				System.out.println("CourseName : " + name);
				System.out.println("CourseCode : " + code);
				System.out.println("StartingDate : " + stDate);
				System.out.println("EndDate : " + enDate);
				 BatchClass b1 = new BatchClass();
				 b1.setBatchCode(bCode);
				 b1.setCourseName(name);
				 b1.setCourseCode(code);
				 b1.setStartingDate(stDate);
				 b1.setEndDate(enDate);
				 BatchDAO dao = DAOFactory.getBatchDAO();
					try {
						dao.save(b1);
						response.sendRedirect("ADD.jsp");
					} catch (DBException e) {
						e.printStackTrace();
					}
		
	}

}
