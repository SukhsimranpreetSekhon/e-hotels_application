<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.booking"%>
<%@page import="eHotel.entities.Room"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Check In</title>
</head>
<body>
	<%
		String custSSN = request.getParameter("custSSN");
		String employeeSSN = request.getParameter("SSN");
	%>
	
	<form method="post" action="checkinconfirm">
	
	<center>
	<table cellpadding=6 cellspacing=4 width = 50%  ><tr><th style='font-size:300%;' colspan=2 bgcolor="lightgrey">Select a Room</th></tr>
				<tr>
				<td align = center>
				
				<select id = "booking_selection" name = "booking_selection">
					<%
						ArrayList<booking> custBookings = null;
						
						Object obj = request.getAttribute("bookings");
						
						
						if (obj instanceof ArrayList) {
							custBookings = (ArrayList<booking>) obj;
							
						}
						
						if (custBookings != null) {
							for (booking book : custBookings) {
									 			
					%>		
						<option value=<%=book.getBooking_id() + "," + book.getHotel_id() + "," + book.getCustomer_ssn() + "," + book.getStart() + "," + book.getEnd() + "," + book.getRoom_no()%>>
						<%="Room #"+book.getRoom_no()+"&nbsp;&nbsp;&nbsp;"+book.getHotel_name()+"&nbsp;&nbsp;&nbsp;"+book.getStart()+" - "+book.getEnd()+"&nbsp;&nbsp;&nbsp;Address: "+ book.getStreet_number() + " "+book.getStreet_name() +" st." +
						", "+ book.getCity()+", "+book.getProvince()+", "+book.getPostal()%></option>
				
					<%
						}
						}
					%>
				</select>
				</td>
				</tr>
				<tr><td align = center><button type="submit" >Check-In Customer</button></td></tr>
				
		</table>
		</center>
		<input type="hidden" id="SSN" name="SSN" value="<%=employeeSSN%>">
		<input type="hidden" id="custSSN" name="custSSN" value="<%=custSSN%>">
	</form>

</body>
</html>