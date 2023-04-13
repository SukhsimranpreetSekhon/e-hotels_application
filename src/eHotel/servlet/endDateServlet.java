package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;

public class endDateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PostgreSqlConn con = new PostgreSqlConn();
		
		String employeeSSN = req.getParameter("SSN");
		String customerSSN = req.getParameter("cust_SSN");
		
		req.setAttribute("custSSN", customerSSN);
		req.setAttribute("SSN", employeeSSN);
		req.getRequestDispatcher("walkin.jsp").forward(req, resp);
		return;
	}

}
