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
import com.swaathi.courseapp.dao.BatchDAO;
import com.swaathi.courseapp.domain.Batch;
import com.swaathi.courseapp.exception.DBException;

@WebServlet("/ListAdminBatches")
@SuppressWarnings("serial")
public class ListAdminBatches extends HttpServlet {
	@Autowired
	BatchDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Batch> list = dao.findAll();
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminBatches.jsp");
			dispatcher.forward(request, response);
		} catch (DBException e) {

			e.printStackTrace();
		}
	}
}