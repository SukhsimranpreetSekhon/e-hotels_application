package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;


public class viewAreaServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		ArrayList<String> cities = con.getCities();
		
		req.setAttribute("cities", cities);
		
		req.getRequestDispatcher("view1.jsp").forward(req, resp);
		
		return;
	}

}
