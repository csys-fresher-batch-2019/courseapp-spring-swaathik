package com.swaathi.courseapp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swaathi.courseapp.dao.impl.StudentImplementation;
import com.swaathi.courseapp.domain.StudentClass;

@SuppressWarnings("serial")
@WebServlet("/Login")

public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean status = false;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		StudentClass user = new StudentClass();
		System.out.println("Enter UserName : "+username);
		user.setUserName(username);
		System.out.println("Enter Password : "+password);
		user.setPassWord(password);
		StudentImplementation dao = new StudentImplementation();
		try {
			status = user.login(user);
			Integer uid = dao.getUserId(user.getUserName(), user.getPassWord());
			if(uid!=null) {
				HttpSession sess = request.getSession();
				sess.setAttribute("admNo", uid);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(status==true) {
			response.sendRedirect("ListCourses");
		}
		else
		{
			request.setAttribute("errorMessage","Invalid Login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
		}
	}

}
