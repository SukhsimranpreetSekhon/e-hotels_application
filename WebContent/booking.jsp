<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.booking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*, java.util.*,javax.servlet.*,java.text.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Booking Page</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="ch-cn">

<script>

	function validate() {
		var start = document.getElementById("start");
		var end = document.getElementById("end");
		var max = document.getElementById("price");
		if(!Date.parse(start.value)){
			alert("Please choose a start date");
			return false;
		}
		else if(!Date.parse(end.value)){
			alert("Please choose an end date");
			return false;
		}
		else if(max.value== ""){
			alert("Please choose a maximum price");
			return false;
		}else
			return true;
			
	}
	</script>
</head>

<style>
ul {
  text-align: center;
  list-style: inside;
}S
</style>
<body>

	<%
		String CustName = (String) request.getAttribute("CustName");
		int userSSN = (Integer) request.getAttribute("userSSN");
	%>
	<form method="post" action="viewBookRoom">
		<center><h4 style='font-size:200%;' >
			Welcome,
			<%=CustName%></h4>
				<h4 style='font-size:150%;'>Here are your bookings:</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookedRooms");
						ArrayList<booking> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<booking>) obj1;
						}
						if (broomList != null) {
							for (booking booking : broomList) {
								String roominfo = booking.getHotel_name()+" &nbsp;&nbsp;&nbsp; \tRoom Number: "+ booking.getRoom_no() + ",&nbsp;&nbsp;&nbsp;\tDate: " + booking.getStart()+" - "+booking.getEnd() + "&nbsp;&nbsp;&nbsp;\t Address: " +booking.getStreet_number()+" "+ booking.getStreet_name()+"&nbsp;&nbsp;&nbsp; st. "+booking.getCity()+", "+booking.getProvince()+", "+booking.getPostal();
					%>
					<li ><%=roominfo%></li>
					<%
						}
						}
					%>
				</ul>
				<%Date now = new Date(); SimpleDateFormat ft = new SimpleDateFormat ("yyyy-mm-dd");%>
				<input type="hidden" name="custName" value="<%=CustName%>">
				<input type="hidden" name="userSSN" value="<%=userSSN%>">
				<h4 align ="center" style='font-size:125%;' >Search for available rooms:</h4>
				
				<table style="width:50%" align = center>
				<tr>
				<td align = center>Start Date: <input type="date" id = "start" name= "start_date" value = ft.format(now) >
				&nbsp;&nbsp;&nbsp;End Date: <input type="date" id = "end" name= "end_date" value = ft.format(now) ></td>
				</tr>
				<tr><td colspan=3>&nbsp;</td></tr>
				<tr>	
				<td align = center> City: <select name ="city">
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
				</select> &nbsp;&nbsp;&nbsp;
				Capacity: <select name = "capacity"><option value= "single">Single</option><option value= "double">Double</option></select>
				</td>
				</tr>
				<tr><td colspan=3>&nbsp;</td></tr>	
				<tr><td align = center> Minimum Rating: <select name = "rating"><option value= "1">1</option><option value= "2">2</option>
				<option value= "3">3</option><option value= "4">4</option><option value= "5">5</option></select>
				&nbsp;&nbsp;&nbsp;Maximum Price: <input type= "number" value = "500" id = "price" name="max_price" >
				</td>
				</tr>
				<tr><td colspan=3>&nbsp;</td></tr>
				<tr>
				<td align = center >
				<button type="submit" value="submit" onclick = "return validate();" >Search Available Rooms</button>
				</td>
				</tr>
				</table>
				</center>
				
	</form>


</body>
</html>