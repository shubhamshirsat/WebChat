<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<%   // Set refresh, autoload time as 5 seconds
response.setIntHeader("Refresh", 1);
%>
<body bgcolor="#F0F0F0 ">

<%

	// if user chooses the name of other user from connection list then name is set in session
	// and we retrive that name from session here...
	
	String chatBoxUserName = (String)session.getAttribute("ChatBoxUserName");

	if(null != chatBoxUserName)		// when logged in, initially it is null
	{
		out.print(""+chatBoxUserName+" - ChatBox");
	}
	else
	{
		out.print("Please Select ChatBox from Chat list....");
	}

%>

</body>
</html>