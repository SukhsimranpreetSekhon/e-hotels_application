<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*, java.util.*,javax.servlet.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Walk-In</title>
</head>
<body>
<form method="post" action="walkinServlet">
<%
String custSSN = (String) request.getAttribute("custSSN");
String employee_SSN = (String) request.getAttribute("SSN");
%>
	<center>
	<table cellpadding=6 cellspacing=4 width = 33% ><tr><th style='font-size:300%;' colspan=2 bgcolor="lightgrey">Walk-In Booking</th></tr>
	<tr><td colspan=2 style = 'font-size:150%;' align = center ><u>Please Select an End Date</u></td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>

	<%Date now = new Date(); SimpleDateFormat ft = new SimpleDateFormat ("yyyy-mm-dd");%>
		<tr><td align = center>End Date: <input type="date" id = "end_date" name= "end_date" value = ft.format(now) ></td></tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr><td align= center>
		<button type="submit" value="submit" onclick="return validate();"><b>Confirm Date</b></button></td></tr>
		</table>
		</center>
		<input type="hidden" id="custSSN" name="custSSN" value="<%=custSSN%>">
		<input type="hidden" id="SSN" name="SSN" value="<%=employee_SSN%>">
	</form>
</body>
</html>