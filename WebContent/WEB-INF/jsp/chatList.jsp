<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.pkg.DataTransferObject.RequestObject" %>
<%@ page import="com.pkg.DataTransferObject.UserInfo"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script>
	
	function searchPopup() 
	{
	    var searchWindow = window.open("searchChat","_self");
  
	}
	
	function acceptRequest(requestor_id) 
	{
		var doc = document.getElementById("AcceptRequestForm");
		doc.requestor_userid.value = requestor_id;
		doc.submit();
	}
	
	
	function startChating(userid, firstname, lastname)
	{
		
		var doc = document.getElementById("prepareChatForm");
		doc.chatUserid.value = userid;
		doc.chatUserFirstName.value = firstname;
		doc.chatUserLastName.value = lastname;
		doc.submit();
	}

	
	function reloadDisplay() 
	{
		//  refers to the display frame and reloads
	  parent.chatWindow.location.reload();	
		parent.titleBar.location.reload();
	}
	
</script>

<style>



</style>
</style>

</head>
<body onload="reloadDisplay()">
	
	<form action="searchChat" method="post">
	<input type="text"  name="chatUserName" class="textbox2" placeholder="Enter your friend's name ....">
	<input type="submit" class="button2" value="Search" onclick="searchPopup()">
	</form>
	
<hr>

<b>Pending Request List</b>
<hr>

 <!-- Accept Connection form-->
	    
    <form id="AcceptRequestForm" action="acceptRequest" method="post">
    	<input type="hidden" name="requestor_userid">
	    
	<%
	   		List<RequestObject> pendingRequestList = (List<RequestObject>) session.getAttribute("PendingRequestList");
	   
	   		if(pendingRequestList != null && pendingRequestList.size() > 0)
	   		{
	%>
    			<table>
	<%
    				for(int i=0; i< pendingRequestList.size(); i++)
    				{
	%>
					<tr>
	<%
						RequestObject pendingRequest = pendingRequestList.get(i); 
	    						
						if(pendingRequest.getRequestType().equals("Accept Request"))
						{
	%>
						<td>
	<%
								out.print(pendingRequest.getFirstname());
	%>
						</td>
   						<td>&nbsp
	<%
								out.print(pendingRequest.getLastname());
	%>
						</td>
						<td>
	<%
								out.print("<a href='#' onclick=\"acceptRequest('"+pendingRequest.getUserid()+"')\">"+ pendingRequest.getRequestType() +"</a>");
	%>	    									
						</td>
	<%
   							}
   							else
   							{
	%>
							<td>
	<%
									out.print(pendingRequest.getFirstname());
	%>
							</td>
							<td>&nbsp
	<%
								out.print(pendingRequest.getLastname());
	%>
							</td>
	<% 
	   							}
	%>
						</tr>
	<%
					}
	%>
	    			</table>
	    			
	<%
	    		}
	    		else
	    		{
	    			
	    			out.print("<br> No new request...");
	    		}
	%>
	    </form>
		    
		    
		<hr><b>Your Chat List</b><hr>
		
		<form id="prepareChatForm" action="prepareChat" method="post">
			<input type="hidden" name="chatUserid">
			<input type="hidden" name="chatUserFirstName">
			<input type="hidden" name="chatUserLastName">
		</form>
		
	<%
				List<RequestObject> acceptedRequestList = (List<RequestObject>) session.getAttribute("AcceptedRequestList");
					
				if(acceptedRequestList != null && acceptedRequestList.size() > 0)
				{
	%>
					<table>
	<%
					for(int i=0; i < acceptedRequestList.size(); i++)
					{
						RequestObject acceptedRequest = acceptedRequestList.get(i);
	%>
						<tr>
						<td>
	<%	
							out.print("<a href=\"#\" onclick=\"startChating('"+acceptedRequest.getUserid()+"','"+acceptedRequest.getFirstname()+"','"+acceptedRequest.getLastname()+"')\">"+acceptedRequest.getFirstname()+"&nbsp");
						
							out.print(acceptedRequest.getLastname()+"</a>");
	%>
						</td></a>
						</tr>
	<%	
						}
					
					}
					else
					{
						out.print("<br> Your chat list is empty ..!!");
					
					}
	%>
		




</body>
</html>