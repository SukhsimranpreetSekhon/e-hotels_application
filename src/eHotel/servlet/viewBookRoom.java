package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.PostgreSqlConn;
import eHotel.entities.Room;

public class viewBookRoom extends HttpServlet {

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String cust_name = req.getParameter("custName");
		int userSSN = Integer.parseInt(req.getParameter("userSSN"));
		
		String start = req.getParameter("start_date");
		String end = req.getParameter("end_date");
		String city = req.getParameter("city");
		String capacity = req.getParameter("capacity");
		int rating = Integer.parseInt(req.getParameter("rating"));
		int max_price = Integer.parseInt(req.getParameter("max_price"));
		
		PostgreSqlConn con = new PostgreSqlConn();
		
		ArrayList<Room> available = con.getAvailRooms(start, end, city, capacity, rating, max_price);
		
		req.setAttribute("available", available);
		req.setAttribute("cust_name",cust_name);
		req.setAttribute("userSSN", userSSN);
		req.setAttribute("start_date", start);
		req.setAttribute("end_date", end);

		req.getRequestDispatcher("availableRooms.jsp").forward(req, resp);
		return;	
	}

}


/*<tr>
<td>

<select name = "roomno">
	<%
		Object obj = request.getAttribute("allRooms");
		ArrayList<Room> roomList = null;
		if (obj instanceof ArrayList) {
			roomList = (ArrayList<Room>) obj;
		}
		if (roomList != null) {
			for (Room room : roomList) {
				 //String roominfo = "Room Number: " +room.getRoom_no()+ "View: "+ room.getView() + "Capacity: "+room.getCapacity(); 
	%>					
		<option><%="Room Number: " +room.getRoom_no()+ "\tView: "+ room.getView() + "\tCapacity: "+room.getCapacity()%></option>

	<%
		}
		}
	%>
</select>
</td>
</tr>
<button type="submit" onclick="return confirm('book?');">book</button>
*/