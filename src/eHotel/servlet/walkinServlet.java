package eHotel.servlet;
import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;
//import eHotel.entities.Room;
import eHotel.entities.booking;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class walkinServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		String custSSN = req.getParameter("custSSN");
		
		String employeeSSN = req.getParameter("SSN");
		
		String end_date = req.getParameter("end_date");
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		
		Date now = new Date();
	
		String start_date= ft.format(now);
		
		System.out.println(start_date);
		
		ArrayList<Room> available = con.getWalkInRooms(employeeSSN, start_date, end_date);
		
		req.setAttribute("employeeSSN", employeeSSN);
		req.setAttribute("custSSN", custSSN);
		req.setAttribute("rooms", available);
		req.setAttribute("start",start_date );
		req.setAttribute("end", end_date);
		req.getRequestDispatcher("walkInRooms.jsp").forward(req, resp);
		
		return;
	}
}
