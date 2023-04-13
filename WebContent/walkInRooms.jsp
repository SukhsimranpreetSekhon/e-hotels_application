<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Rooms</title>
</head>
<body>
		<%
		String custSSN = (String) request.getAttribute("custSSN");
		String employeeSSN = (String) request.getAttribute("employeeSSN");
		String start = (String) request.getAttribute("start");
		String end = (String) request.getAttribute("end");
		%>
		
	<form method="post" action="rentRoomServlet">
	<center>
	<table cellpadding=6 cellspacing=4 width = 50%  ><tr><th style='font-size:300%;' colspan=2 bgcolor="lightgrey">Please Select a Room</th></tr>
				<tr>
				<td align = center>
				
				<select name = "room_book">
					<%
						Object obj = request.getAttribute("rooms");
						ArrayList<Room> roomList = null;
						
						if (obj instanceof ArrayList) {
							roomList = (ArrayList<Room>) obj;
							
						}
						if (roomList != null) {
							for (Room room : roomList) {
								 
									String extend = new String();
									if(room.isExtendable()){
										extend = "Yes";
									}
									else{
										extend="No";
									}
									
					%>		
					
						<option value=<%=room.getHotel_id()+","+room.getRoom_no()+","+start+","+end+","+custSSN%>>
						<%="Room: #" + room.getRoom_no() + ", $" + room.getPrice()+ ", " +room.getCapacity()+ ", " + room.getView()+ ", Extendable: " + extend%></option>
				
					<%
						}
						}
					%>
				</select>
				</td>
				</tr>
				<tr><td align = center>
				<input type="hidden" id="employeeSSN" name="employeeSSN" value="<%=employeeSSN%>"></td></tr>
				<tr><td align = center><button type="submit" >Rent Room</button></td></tr>
		</table>
		</center>
	</form>
</body>
</html>