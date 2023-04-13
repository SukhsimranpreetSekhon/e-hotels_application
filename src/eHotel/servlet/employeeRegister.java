package eHotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;


public class employeeRegister extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		String hotel_id = req.getParameter("hotel_id");
		String custPwd = req.getParameter("custPwd");
		PostgreSqlConn con = new PostgreSqlConn();
		con.employee(hotel_id,custStreetName,custStreetNumber,custCity,custZipPostal,custProvince,custFirstName,custMiddleInitial,custLastName,Integer.parseInt(custSSN),custPwd);
		resp.sendRedirect("employee_register.html");
		return;		
	}

}
