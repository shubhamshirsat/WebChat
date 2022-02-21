package com.pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pkg.BusinessLogic.AdminLogic;
import com.pkg.BusinessLogic.ChatLogic;
import com.pkg.DataTransferObject.UserInfo;
import com.pkg.Utility.StatusConstants;


public class SendRequestServlet extends BaseServlet 
{
	private static final long serialVersionUID = 1L;
       
   
    public SendRequestServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int acceptorId = Integer.parseInt(request.getParameter("acceptorId"));
		String firstName = request.getParameter("acceptorFirstName");
		String lastName = request.getParameter("acceptorLastName");
		Integer requestStatus = null;
				
		UserInfo userInfo = getUserInfoFromSession(request);
		
		if(userInfo.getUserid() != acceptorId)
		{
			requestStatus = chatLogic.sendRequest(userInfo.getUserid(), acceptorId);
		
		
			if(requestStatus == StatusConstants.REQUESTSEND)
			{
				request.setAttribute("message", "Request sent successfully to "+firstName+" "+lastName);
			}
			else if(requestStatus == StatusConstants.PENDING)
			{
				
				request.setAttribute("message", "Request Pending ...");
			}
			else if(requestStatus == StatusConstants.ACCEPTED)
			{
				request.setAttribute("message", "Connection already exist ...");
			
			}
		}
		else
		{
			
			request.setAttribute("message", "Request cannot be sent..");
		}
		
		

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/searchChat.jsp");
		requestDispatcher.forward(request, response);
	}

}
