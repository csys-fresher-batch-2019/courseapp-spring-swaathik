package com.swaathi.courseapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swaathi.courseapp.dao.StudentDAO;
import com.swaathi.courseapp.domain.StudentClass;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.factory.DAOFactory;
import com.swaathi.courseapp.service.UserService;

@SuppressWarnings("serial")
@WebServlet("/Register")

public class Register extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String fname = request.getParameter("fname");
		String email = request.getParameter("email");
		String doj = request.getParameter("doj");
		LocalDate dateOfJoining = LocalDate.parse(doj);
		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		String phoneNo = request.getParameter("phNo");

		System.out.println("Name : " + name);
		System.out.println("FatherName : " + fname);
		System.out.println("Mail Id : " + email);
		System.out.println("Date Of Enroll : " + dateOfJoining);
		System.out.println("Username : " + Username);
		System.out.println("Password : " + password);
		System.out.println("PhoneNumber : " + phoneNo);
		StudentClass s1 = new StudentClass();

		s1.setFullName(name);
		s1.setPhoneNo(phoneNo);
		s1.setFatherNameOrGuardianName(fname);
		s1.setEmailId(email);
		s1.setDateOfJoining(LocalDate.parse(doj));
		s1.setUserName(Username);
		s1.setPassWord(password);

		HttpSession ses = request.getSession();
		ses.setAttribute("user", name);
		boolean status = false;
		
		try {
			status = validate(email, Username, phoneNo);
			System.out.println(status);
			if (status) {
				request.setAttribute("errorMessage", "Registered Already!!!Please Login");
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);
			}

			else {
				System.out.println(s1);
				UserService.registration(s1);
				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			request.setAttribute("errorMessage", "Registered Already!!!Please Login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);

		}

	}

	private boolean validate(String email, String Username, String phoneNo) throws DBException {
		boolean status = false;
		StudentDAO dao = DAOFactory.getStudentDAO();
		List<StudentClass> list = dao.findAll();

		for (StudentClass s : list) {

			String userName = s.getUserName();
			String mailId = s.getEmailId();
			String ph = s.getPhoneNo();
			if (userName.equals(Username) || mailId.equals(email) || ph.equals(phoneNo)) {
				status = true;
				break;
			}
		}
		return status;
	}

}
