<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pick City</title>
</head>
<body>
<form method="post" action="hotelAreaServlet">
<center>
	<table cellpadding=6 cellspacing=4 width = 40% ><tr><th style='font-size:300%;' colspan=2 bgcolor="lightgrey">Number of Rooms by Area</th></tr>
				<tr><td colspan=3>&nbsp;</td></tr>
				
				<tr><td align = center>
	City: <select name ="city">
				<%
				
					Object ob = request.getAttribute("cities");
					ArrayList<String> cities = null;
					if (ob instanceof ArrayList) {
						cities = (ArrayList<String>) ob;
					}
					if (cities != null){
						for (String city : cities){
							
				%>
				<option><%=city%></option>
				<%
						}
					}
				%>			
				</select>
				</td></tr>
				<tr><td colspan=3>&nbsp;</td></tr>
				<tr><td align=center>
				<button type="submit" value="submit" >Choose City</button></td></tr>
				</table>
				</center>
				</form>

</body>
</html>