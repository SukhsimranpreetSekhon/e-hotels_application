package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;


public class checkinconfirm extends HttpServlet {

   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		String employee_ssn = req.getParameter("SSN");
		
		List<String> myList = new ArrayList<String>(Arrays.asList((req.getParameter("booking_selection").split(","))));
		
		int max = con.getmaxrent();
		
		con.checkin(max + 1, Integer.parseInt(myList.get(0)), Integer.parseInt(employee_ssn), Integer.parseInt(myList.get(2)), myList.get(3), myList.get(4), Integer.parseInt(myList.get(5)), Integer.parseInt(myList.get(1)));
		
		req.getRequestDispatcher("login_success.jsp").forward(req, resp);
		return;
	}

}
