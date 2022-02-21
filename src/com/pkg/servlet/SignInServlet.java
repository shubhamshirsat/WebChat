package com.pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg.Utility.StatusConstants;
import com.pkg.DataTransferObject.UserInfo;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String forwardPath = "index.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserInfo userInfo = null;
		
		try 
		{
			userInfo = adminLogic.getUserInfo(username);
			
			if (isUserValid(userInfo, password) && adminLogic.updateStatus(userInfo.getUserid(), StatusConstants.LOGGEDIN)) 
			{
				forwardPath = "WEB-INF/jsp/container.jsp";
				
				setUserInfoInSession(request, userInfo);
				setPendingRequestInSession(request, userInfo);
				setAcceptedRequestInSession(request, userInfo);
			}
			else
			{
				request.setAttribute("message", "Incorrect user name or password");
			}
		}
		catch (Exception e) 
		{
			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);	//  forwards the user to next page if login successful
		dispatcher.forward(request, response);
	}
	
	
	
	//========================================  validate user  ====================================================
	
	
			private boolean isUserValid(UserInfo userInfo, String password)
			{
				boolean result = false;
			
				try
				{
					System.out.println(userInfo.getEmail());
				
					if(userInfo != null && password.equals(userInfo.getPassword()))
					{
						result = true;
					}
				
				}
				catch(Exception e)
				{
				
					System.out.println(e);
				}
			
				return result;
			}


}
