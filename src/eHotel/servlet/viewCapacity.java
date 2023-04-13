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
import eHotel.entities.Hotel;
import eHotel.entities.Room;

public class viewCapacity extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		String hotel = req.getParameterValues("hotel")[0];
		
		ArrayList<Room> rooms = con.getHotelRooms(hotel);
		
		req.setAttribute("rooms", rooms);
		
		req.getRequestDispatcher("view2.jsp").forward(req, resp);
		
		return;
	}

}
