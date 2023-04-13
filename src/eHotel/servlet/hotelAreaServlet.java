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

public class hotelAreaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		String area = req.getParameter("city");
		
		ArrayList<Hotel> hotelsByArea = con.getHotelsByArea(area);
		
		req.setAttribute("hotels", hotelsByArea);
		
		req.getRequestDispatcher("view_hotel.jsp").forward(req, resp);
		
		return;
	}

}
