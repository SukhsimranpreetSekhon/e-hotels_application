<%@ page import = "java.io.*, java.util.*,javax.servlet.*,java.text.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login success</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="ch-cn">
</head>
<body>
	<%
		String employee_name = (String) request.getAttribute("name");
		String employee_SSN = (String) request.getAttribute("ssn");
		System.out.println(employee_SSN);
	%>

	<center>
	
	<table cellpadding=6 cellspacing=4 width = 40% ><tr><th style='font-size:300%;' colspan=2 bgcolor="lightgrey">Welcome, Employee</th></tr>
	<tr><td colspan=2 style = 'font-size:150%;' align = center ><u>Please Choose an Option</u></td></tr>
	<tr><td colspan=3>&nbsp;</td></tr>
	<tr><td colspan=2 align = center>Customer SSN: <input type="number" id="custSSN" name="custSSN">
	<tr><td colspan=3>&nbsp;</td></tr>
	</table>
	</center>
	
	<script>
	function setVal(){
		var custSSN = document.getElementById("custSSN").value;
		document.getElementById("c_SSN").value = custSSN;
	}
		
	</script>
	<script>
	function setVal2(){
		var custSSN = document.getElementById("custSSN").value;
		document.getElementById("cust_SSN").value = custSSN;
	}
		
	</script>
	
	<form method = post action ="checkinServlet" onSubmit = "setVal();">
	<center>
	<table cellpadding=6 cellspacing=4 width = 40% >
	<tr><td colspan=2 align = center>
	<input type = "hidden" id = "c_SSN" name = "c_SSN" value ="" ></input>
	<input type="hidden" id="SSN" name="SSN" value="<%=employee_SSN%>">
	<button type = "submit" ><b>Check-In</b></button>
	</td></tr>
	</table>
	</center>
	</form>
	
	<form method = post action = "endDateServlet" onSubmit = "setVal2();">
	<center>
	<table cellpadding=6 cellspacing=4 width = 40% >
	<tr><td colspan=2 align = center>
	<input type = "hidden" id = "cust_SSN" name = "cust_SSN" value ="" ></input>
	<input type="hidden" id="SSN" name="SSN" value="<%=employee_SSN%>">
	<button type = "submit" ><b>Walk-In</b></button>
	</td></tr>
	</table>
	</center>
	</form>
	
	
	<input type="hidden" id="name" name="name" value="<%=employee_name%>">
</body>
</html>
