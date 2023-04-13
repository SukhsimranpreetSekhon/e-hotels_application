package eHotel.servlet;

import eHotel.connections.PostgreSqlConn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.entities.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkinServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		int custSSN =  Integer.parseInt(req.getParameter("c_SSN"));
		
		String employee_ssn = req.getParameter("SSN");
		
		ArrayList<booking> custBookings = con.getbookedRooms(custSSN);
		
		req.setAttribute("custSSN", custSSN);
		req.setAttribute("SSN", employee_ssn);
		req.setAttribute("bookings", custBookings);
		
		
		
		req.getRequestDispatcher("checkin.jsp").forward(req, resp);
		
		return;
		
	}

}
