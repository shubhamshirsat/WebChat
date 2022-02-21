package com.pkg.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg.DataTransferObject.UserInfo;

/**
 * Servlet implementation class SearchChatServlet
 */
public class SearchChatServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchChatServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/searchChat.jsp");
			requestDispatcher.forward(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserInfo userInfo = getUserInfoFromSession(request);
		String chatUserName = request.getParameter("chatUserName");
		
		try 
		{
			List<UserInfo> userInfos = adminLogic.searchUsers(chatUserName);
			
				if(null != userInfos)
				{
						request.setAttribute("searchedUserList", userInfos);
							
				}
				else
				{
					request.setAttribute("message", "Item Not Found!!");
				}
		}
		catch (Exception e)
		{
		
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/searchChat.jsp");
		requestDispatcher.forward(request, response);
	}

	
	/*
	private void removeSessionUser(List<UserInfo> userInfos, UserInfo userInfo) 	
	{
		
		Iterator<UserInfo> it = userInfos.iterator();
		while(it.hasNext())
		{
			UserInfo info = it.next();
			if(info.getUserid() == (userInfo.getUserid()))
			{
				it.remove();
			}
		}
		
	}*/
}
