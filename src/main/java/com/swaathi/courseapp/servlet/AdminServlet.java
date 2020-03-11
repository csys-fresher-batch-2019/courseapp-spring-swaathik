package com.swaathi.courseapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swaathi.courseapp.domain.Admin;

@SuppressWarnings("serial")
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Admin user = new Admin();
		System.out.println("Enter UserName : " + username);
		user.setUserName(username);
		System.out.println("Enter Password : " + password);
		user.setPassword(password);

		if (username.equals("Swaathi") && password.equals("12345"))
			response.sendRedirect("viewAdmin.jsp");
		else {
			request.setAttribute("Error Message", "Invalid Login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
			dispatcher.forward(request, response);
		}
	}
}