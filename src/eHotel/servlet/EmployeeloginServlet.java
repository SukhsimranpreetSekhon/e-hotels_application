package eHotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
//import eHotel.entities.employee;

public class EmployeeloginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//employee account = new employee();
		String userSSN = req.getParameter("userSSN");
		String pwd = req.getParameter("pwd");
		
		PostgreSqlConn con = new PostgreSqlConn();
		String[] pwdfromdb = con.getpwdbyUname(userSSN);
		
		//System.out.println(pwdfromdb[0]);
		
		if (pwd.equals(pwdfromdb[0])) {
			
				req.setAttribute("ssn", userSSN);
				req.setAttribute("name", pwdfromdb[1]);
				
				System.out.println(req.getAttribute("name"));
				
				req.getRequestDispatcher("login_success.jsp").forward(req, resp);
				return;
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}