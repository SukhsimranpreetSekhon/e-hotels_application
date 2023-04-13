package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;
import eHotel.entities.booking;
import eHotel.entities.employee;


public class CustomerloginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		int userSSN = Integer.parseInt(req.getParameter("userSSN"));
		String pwd = req.getParameter("pwd");
		
		PostgreSqlConn con = new PostgreSqlConn();
//		[0]:name,[1]:pwd
		String[] pwdfromdb = con.getuserinforbycustSSN(userSSN);
		
		
		
		if (pwd.equals(pwdfromdb[1])) {			
			System.out.println("yes");
			ArrayList<booking> bookedRooms = con.getbookedRooms(userSSN);
			
			ArrayList<Room> allRooms = con.getAllAvailRooms();
			
			ArrayList<String> cities = con.getCities();
			
			
			req.setAttribute("CustName", pwdfromdb[0]);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);
			req.setAttribute("cities", cities);
			req.setAttribute("userSSN", userSSN);
			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}