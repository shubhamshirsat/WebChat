<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.pkg.DataTransferObject.MessageObject"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>


	html
	{
		font-family:sans-serif;
		-ms-text-size-adjust:100%;
		-webkit-text-size-adjust:100%
	}

	body
	{
			margin-right: 150px;
		    margin-left: 150px;
	}

	/*------------  Discussion panel  --------------*/
	.discussion 
	{
		  list-style: none;
		  //background: #e5e5e5;
		  margin: 0;
		  padding: 0 0 50px 0;
	}


	/*---------------  Message template as flex ------------------- */
	.discussion li 
	{
		  padding: 0.5rem;
		  overflow: hidden;
		  display: flex;
	}


	.discussion .avatar 
	{
		  width: 80px;
		  position: relative;
	}


	.discussion .avatar img 
	{
		  display: block;
		  width: 100%;
	}


	.other .avatar:after 
	{
		  content: "";
		  position: absolute;
		  top: 10;
		  right: 0;
		  width: 0;
		  height: 0;
		  border: 10px solid #800080;
		  border-left-color: transparent;
		  border-bottom-color: transparent;
	}


/*--------- sender message template and pics  ----------*/

	.self 
	{
		  justify-content: flex-end;
		  align-items: flex-end;
		  color: white;
	}
	
	.other
	{
		  
			color: white;
	}

	.self .messages 
	{
	  	  order: 1;
		  border-bottom-right-radius: 0;
	}

	
	.self .avatar 
	{
		  order: 2;
	}


	.self .avatar:after 
	{

		  content: "";
		  position: absolute;
		  bottom: 10;
		  left: 0;
		  width: 0;
		  height: 0;
		  border: 10px solid #3399ff;
		  border-right-color: transparent;
		  border-top-color: transparent;
		  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
	}


	/*----------------- Message template color and its shape -----------------------*/
	.messages1 
	{
		  background: #3399ff;
		  padding: 10px;
		  border-radius: 2px;
		  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	}
	
	.messages2 
	{
		  background: #800080;
		  padding: 10px;
		  border-radius: 2px;
		  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	}


	/*------------------   Message font  size------------------------*/
	.messages p 
	{
		  font-size: 0.9rem;
		  margin: 0 0 0.2rem 0;
	}


	.messages time 
	{
		  font-size: 0.7rem;
		  color: #ccc;
	}


	@keyframes pulse 
	{
		  from 
		{
		    opacity: 0;
		}

	          to 
		{
		    opacity: 0.5;
 		 }
	}


</style>

<title>Insert title here</title>

<%   // Set refresh, autoload time as 5 seconds
response.setIntHeader("Refresh", 3);
%>
</head>
<body>


<ol class="discussion">

<%

	String chatBoxUserName = (String)session.getAttribute("ChatBoxUserName");
	String chatBoxKey = (String)session.getAttribute("ChatBoxKey");

	Map<String,List> map = (Map<String, List>) application.getAttribute("ChatBox");

	if(null != map)
	{
		List<MessageObject> list = map.get(chatBoxKey);

		if(null != list)
		{
%>
			<ol class="discussion">
	
<%
		for(int i = 0; i<list.size(); i++)
		{
%>
		

<%
		
		if(chatBoxUserName.equals(list.get(i).getUserName()))
		{
%>			
			<li class="other">
  			<div class="messages1">
        	<p>
 <%
    		out.println(list.get(i).getMessage());
 %>
        	</p>
        	</div>
    		</li>
<%			
		}
		else
		{
%>
	
		<li class="self">      
		<div class="messages2">
        	<p>
 <%
    		out.println(list.get(i).getMessage());
 %>
        	</p>
        	
      		</div>
    	</li>
			
      	
<%	
		}
%>
		

<%
	}
%>
	
<%
	}
}

%>
</ol>
</body>
</html>