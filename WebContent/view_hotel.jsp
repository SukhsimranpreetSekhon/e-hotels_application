<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Hotel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotels by Area</title>
</head>
<body>

<form method="post" action="viewCapacity">
<center>
	<table cellpadding=6 cellspacing=4 width = 40% ><tr><th style='font-size:300%;' colspan=2 bgcolor="lightgrey">Please Pick a Hotel</th></tr>
				<tr><td colspan=3>&nbsp;</td></tr>
				
				<tr><td align = center>
	Hotels: <select name ="hotel">
				<%
				
					Object ob = request.getAttribute("hotels");
					ArrayList<Hotel> hotels = null;
					if (ob instanceof ArrayList) {
						hotels = (ArrayList<Hotel>) ob;
					}
					if (hotels != null){
						for (Hotel hotel : hotels){
							
				%>
				<option value=<%=hotel.getHotel_id()%>><%=hotel.toString()%></option>
				<%
						}
					}
				%>			
				</select>
				</td></tr>
				<tr><td colspan=3>&nbsp;</td></tr>
				<tr><td align =center>
				<button type="submit" value="submit" >Choose Hotel</button></td></tr>
				</table>
				</center>
				</form>

</body>
</html>