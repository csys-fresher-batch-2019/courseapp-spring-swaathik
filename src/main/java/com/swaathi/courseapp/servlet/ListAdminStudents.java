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
import com.swaathi.courseapp.dao.StudentDAO;
import com.swaathi.courseapp.domain.StudentClass;
import com.swaathi.courseapp.exception.DBException;
@WebServlet("/ListAdminStudents")
@SuppressWarnings("serial")
public class ListAdminStudents extends HttpServlet {
	@Autowired
	StudentDAO dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<StudentClass> list =dao.displayStudents();
		
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
			dispatcher.forward(request, response);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
}
}