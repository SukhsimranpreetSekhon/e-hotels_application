package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;


public class manlogin extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int userSSN = Integer.parseInt(req.getParameter("userSSN"));
		String pwd = req.getParameter("pwd");
		PostgreSqlConn con = new PostgreSqlConn();
		String[] pwdfromdb = con.manPass(userSSN);
		
		if (pwd.equals(pwdfromdb[1])) {	
			
			req.setAttribute("manName", pwdfromdb[0]);
			
			req.getRequestDispatcher("employee_register.html").forward(req, resp);
			return;
		}
		
		resp.sendRedirect("login_failure.jsp");
		return;
		
		
	}

}
