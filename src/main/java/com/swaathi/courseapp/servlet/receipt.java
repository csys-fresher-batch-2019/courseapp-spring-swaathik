package com.swaathi.courseapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swaathi.courseapp.dao.PaymentDAO;
import com.swaathi.courseapp.domain.Payment;
import com.swaathi.courseapp.exception.DBException;
import com.swaathi.courseapp.factory.DAOFactory;

@SuppressWarnings("serial")
@WebServlet("/receipt")

public class Receipt extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		int admNo = (Integer) (sess.getAttribute("admNo"));
		String amount = request.getParameter("amountPaid");
		int amountPaid = Integer.valueOf(amount);
		String remark = request.getParameter("reMarks");
		System.out.println("Admission No : " + admNo);
		System.out.println("Amount : " + amountPaid);
		System.out.println("Remarks : " + remark);
		Payment b1 = new Payment();
		b1.setAdmNo(admNo);
		b1.setAmountPaid(amountPaid);
		b1.setReMarks(remark);
		PaymentDAO dao = DAOFactory.getPaymentDAO();
		try {
			dao.save(b1);
		} catch (DBException e) {
			e.printStackTrace();
		}
		response.sendRedirect("EnrollMent.jsp");

	}

}
