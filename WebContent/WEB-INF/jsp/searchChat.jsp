<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List" %>
<%@page import="com.pkg.DataTransferObject.UserInfo" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>


<script type="text/javascript">

		
	
	function searchPopup() 
	{
	    var searchWindow = window.open("searchChat.jsp","_self");
	  
	}
	
	function sendRequest(userId, firstname, lastname) 
	{
		var doc= document.getElementById("sendRequestForm");
		doc.acceptorId.value = userId;
		doc.acceptorFirstName.value = firstname;
		doc.acceptorLastName.value = lastname;
		doc.submit();
		
		parent.chatList.location.reload();
	}
	
	function reloadChatList()
	{
		parent.chatList.location.reload();
	}
	
</script>


</head>
<body  onload="reloadChatList">

	<form action="searchChat" method="post">
	<input type="text" name="chatUserName" class="textbox2" placeholder="Enter your friend's name ....">
	<input type="submit" class="button2" value="Search" onclick="searchPopup()">
	</form>
	<a href="chatList">back</a>
	<hr>
	
	
		<form id="sendRequestForm" action="sendRequest" method="post">
	    <input type="hidden" name="acceptorId">
	    <input type="hidden" name="acceptorFirstName">
	    <input type="hidden" name="acceptorLastName">
	    </form>
	<%
			List<UserInfo> userInfoList = (List<UserInfo>) request.getAttribute("searchedUserList");

			if(userInfoList != null)
			{
				out.print("<table>");
						
				for(int i=0;i<userInfoList.size();i++)
				{
					out.print("<tr>");
					UserInfo userInfo = userInfoList.get(i);
					out.println("<td>"+userInfo.getFirstname()+" "+userInfo.getLastname()+"</td>");
					out.print("<td><a href=# onclick=\"sendRequest('"+userInfo.getUserid()+"','"+userInfo.getFirstname()+"','"+userInfo.getLastname()+"')\">&nbsp&nbspSend Request </a></td>");
					out.print("</tr>");
			
				}
					out.print("</table>");
			}
	
			String msg = (String) request.getAttribute("message");

			if(msg != null)
			{
					out.print(msg);
			}
	
	%>	
	
	
</body>
</html>