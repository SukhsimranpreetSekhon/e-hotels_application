package eHotel.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;
import eHotel.entities.booking;

public class CustomerRegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
//		employee account = new employee();
		String custSSN = req.getParameter("custSSN");
		
		String custFirstName = req.getParameter("firstName");
		String custMiddleInitial = req.getParameter("middleInitial");
		String custLastName = req.getParameter("lastName");
		
		String custStreetName = req.getParameter("streetName");
		String custStreetNumber = req.getParameter("streetNumber");
		String custZipPostal = req.getParameter("postal");
		String custCity = req.getParameter("city");
		String custProvince = req.getParameter("province");
		
		String custPwd = req.getParameter("custPwd");
		PostgreSqlConn con = new PostgreSqlConn();
		
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		Date now = new Date();
	
		String date= ft.format(now);
		
		System.out.println(date);
		con.insertNewCustomer(custStreetName,custStreetNumber,custCity,custZipPostal,custProvince,custFirstName,custMiddleInitial,custLastName,Integer.parseInt(custSSN),custPwd,date);
		resp.sendRedirect("customer_login.html");
		return;				
		}
		

}
