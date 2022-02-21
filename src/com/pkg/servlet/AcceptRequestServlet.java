package com.pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg.DataTransferObject.UserInfo;

/**
 * Servlet implementation class AcceptRequestServlet
 */
public class AcceptRequestServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AcceptRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int requestorid = Integer.parseInt(request.getParameter("requestor_userid"));
		UserInfo userInfo = getUserInfoFromSession(request);
		
		boolean isAccepted = chatLogic.acceptRequest(userInfo.getUserid(), requestorid);
		
		if(isAccepted)
		{
			
			setPendingRequestInSession(request, userInfo);
			setAcceptedRequestInSession(request, userInfo);
			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/chatList.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
