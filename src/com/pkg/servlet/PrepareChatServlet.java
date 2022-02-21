package com.pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg.DataTransferObject.UserInfo;

/**
 * Servlet implementation class PrepareChatServlet
 */
public class PrepareChatServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrepareChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			int chatUserid = Integer.parseInt(request.getParameter("chatUserid"));
			String chatUserFirstName = request.getParameter("chatUserFirstName"); 
			String chatUserLastName = request.getParameter("chatUserLastName");
			String chatUserName = null;
			
			UserInfo userInfo =	getUserInfoFromSession(request);
			int loginUserid = userInfo.getUserid();
			chatUserName = ""+chatUserFirstName+" "+chatUserLastName;
			
			initChatBox(request, loginUserid, chatUserid, chatUserName);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/chatList.jsp");
			requestDispatcher.forward(request, response);
	}

}
