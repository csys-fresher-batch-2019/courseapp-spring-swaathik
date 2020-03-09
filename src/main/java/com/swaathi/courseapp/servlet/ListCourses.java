package com.swaathi.courseapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;

import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.domain.CourseClass;
import com.swaathi.courseapp.exception.DBException;
@WebServlet("/ListCourses")
@SuppressWarnings("serial")
public class ListCourses extends HttpServlet {
	@Autowired
	CourseDAO dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<CourseClass> list = dao.findAll();
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("course.jsp");
			dispatcher.forward(request, response);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
}
}