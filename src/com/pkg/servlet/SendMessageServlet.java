package com.pkg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pkg.DataTransferObject.MessageObject;
import com.pkg.DataTransferObject.UserInfo;


/**
 * Servlet implementation class SendMessageServlet
 */
public class SendMessageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/sendMessage.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String chatMessage = request.getParameter("message");

		HttpSession httpSession = request.getSession(true);
		String chatBoxKey = (String) httpSession.getAttribute("ChatBoxKey");

		List<MessageObject> list = getChatBoxItems(request, chatBoxKey);
	
		if (null != list) 
		{
			UserInfo userInfo = getUserInfoFromSession(request);

			MessageObject message = new MessageObject();
			message.setMessage(chatMessage);
			message.setUserid(userInfo.getUserid());
			message.setUserName(userInfo.getFirstname()+" "+userInfo.getLastname());

			list.add(message);
			System.out.println("chatMessage --> " + chatMessage);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/sendMessage.jsp");
		requestDispatcher.forward(request, response);
	}

}
