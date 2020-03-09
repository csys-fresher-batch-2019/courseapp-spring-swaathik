package com.swaathi.courseapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.dao.CourseDAO;
import com.swaathi.courseapp.domain.BatchClass;
import com.swaathi.courseapp.domain.CourseClass;
import com.swaathi.courseapp.exception.DBException;
@WebServlet("/ListBatches")
@SuppressWarnings("serial")
public class ListBatches extends HttpServlet {
	@Autowired
	CourseDAO dao;
	@Autowired
	BatchDAO b;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String courseName = request.getParameter("course_name");
			List<CourseClass> list = dao.findByCourseName(courseName); 
			CourseClass course = list.get(0);
			System.out.println("CourseDetail" +  course);
			
			List<BatchClass> l = b.findByCourseName(courseName);
			System.out.println("BATCH_CLASS" + l);
			 request.setAttribute("BATCH_CLASS", l);
            request.setAttribute("COURSE_DETAIL", course);
            HttpSession session = request.getSession();
            //ses.setAttribute("fees",course.getCourseFee());
        	session.setAttribute("name",courseName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("enroll.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (DBException | SQLException e) {
			
			e.printStackTrace();
		}
}
	
}