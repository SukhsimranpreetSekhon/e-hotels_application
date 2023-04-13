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


public class view1Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		ArrayList<String> cities = con.getCities();
		ArrayList<String> area = new ArrayList<String>();
		
		
		for(int i = 0; i< cities.size(); i++ ){
			String num = con.getCityCount(cities.get(i));
			area.add(num);
		}
		
		req.setAttribute("cities", area);
		
		//System.out.println(city.get(0));
		
		req.getRequestDispatcher("view_area.jsp").forward(req, resp);
		
		return;
	}

}
