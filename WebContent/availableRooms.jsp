<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>View Available Rooms</title>
</head>
<body>
		<%
		String CustName = (String) request.getAttribute("cust_name");
		int userSSN = (Integer) request.getAttribute("userSSN");
		String start= (String) request.getAttribute("start_date");
		String end= (String) request.getAttribute("end_date");
		%>
		
	<form method="post" action="roombook">
	
	<center>
	<table cellpadding=6 cellspacing=4 width = 50%  ><tr><th style='font-size:300%;' colspan=2 bgcolor="lightgrey"> Select a Room, <%=CustName%></th></tr>
				<tr>
				<td align = center>
				
				<select name = "room_selection">
					<%
						Object obj = request.getAttribute("available");
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
					
						<option value=<%= room.getHotel_id() +","+room.getRoom_no()+","+start+","+end+","+userSSN %>>
						<%=room.getChain_name()+" (" +room.getRating()+" star)"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Address: "+room.getStreet_number() + " "+room.getStreet_name() +" st." +
						", "+ room.getCity()+", "+room.getState_province() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Room: "+"$"+room.getPrice()+", "+room.getCapacity()+", "+ room.getView()+", extendable: " +extend%></option>
				
					<%
						}
						}
					%>
				</select>
				</td>
				</tr>
				
				<tr><td align = center><input type="hidden" name="userSSN" value="<%=userSSN%>">
				<input type="hidden" name="custName" value="<%=CustName%>"></td></tr>
				<tr><td align = center><button type="submit" >book</button></td></tr>
		</table>
		</center>
	</form>
</body>
</html>