<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body><br><br><br><br><br><br><br><br>
	<table align="center">
	<tr>
	<td>
	<form action="signIn" method="post">
		<input type="text" name="username" class="textbox" placeholder="E mail id"><br><br>
		<input type="password" name="password" class="textbox" placeholder="Password"><br><br>
		<input type="submit" class="button button1" value="Sign In">
	</td>
	</tr>
	</form>
	<tr>
	<td>
	Havn't account <a href="#" onclick="window.location.href='signUp'"><font color="blue">Sign up</font></a> here
	</td>
	</tr>
	</table>
	<br><br>
	
	<%
		String message = (String)request.getAttribute("message");
	%>
	
	<%
		if(message != null)
		{
			out.print("<h3 align=center>"+message+"</h3>");
		}
	%>
</body>
</html>