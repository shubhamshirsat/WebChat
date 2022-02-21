<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.pkg.DataTransferObject.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#F0F0F0">

<table>
<tr>
<td>
<img src="user.png" style = "border-radius:50% 50% 50% 50%; width:30px;	height:30px;">
</td>
<td>
<%
	UserInfo userInfo = (UserInfo) session.getAttribute("UserInfo");
	
	out.print((String) userInfo.getFirstname()+" "+ (String) userInfo.getLastname());
%>
</td>

<td>
<a href="logout" target="_parent">Logout</a>	
</td>
</body>
</html>