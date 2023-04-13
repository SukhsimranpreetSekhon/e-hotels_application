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

public class rentRoomServlet extends HttpServlet {
        
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		List<String> myList = new ArrayList<String>(Arrays.asList((req.getParameter("room_book").split(","))));
		
		System.out.println(myList.get(0)+" Hotel_id");
		System.out.println(myList.get(1)+" Room No");
		System.out.println(myList.get(2)+" start");
		System.out.println(myList.get(3)+" end");
		System.out.println(myList.get(4)+" ssn");
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		int employeeSSN = Integer.parseInt(req.getParameter("employeeSSN"));
		
		int booking_id = con.getBookingId();
		
		int renting_id = con.getmaxrent();
		
		//room.getHotel_id()+","+room.getRoom_no()+","+start+","+end+","+custSSN
		
		con.bookRoom(booking_id + 1, Integer.parseInt(myList.get(0)), Integer.parseInt(myList.get(4)), myList.get(2), myList.get(3), Integer.parseInt(myList.get(1)));
		
		con.checkin(renting_id + 1, booking_id + 1, employeeSSN, Integer.parseInt(myList.get(4)), myList.get(2), myList.get(3), Integer.parseInt(myList.get(1)), Integer.parseInt(myList.get(0)));
		
		req.getRequestDispatcher("login_success.jsp").forward(req, resp);
		
		return;
	}

}
