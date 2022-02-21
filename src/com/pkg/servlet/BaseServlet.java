package com.pkg.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pkg.BusinessLogic.AdminLogic;
import com.pkg.BusinessLogic.ChatLogic;
import com.pkg.DataAccessObject.AdminDataAccess;
import com.pkg.DataTransferObject.MessageObject;
import com.pkg.DataTransferObject.RequestObject;
import com.pkg.DataTransferObject.UserInfo;
import com.pkg.Utility.StatusConstants;





/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet 
{
	public AdminLogic adminLogic = new AdminLogic();
	public ChatLogic chatLogic = new ChatLogic();
	
	
	public UserInfo getUserInfoFromSession(HttpServletRequest request) 
	{
		HttpSession session = request.getSession(true);
		UserInfo userInfo = (UserInfo)session.getAttribute("UserInfo");
		return userInfo;
	}
	
	
	
	/**
	 * Set userInfo in session to identify old user for further request   
	 * @param request
	 * @param userInfo
	 */
	public void setUserInfoInSession(HttpServletRequest request, UserInfo userInfo) 
	{
		HttpSession httpSession = request.getSession();		// get httpSession object if not exist then creates a new
		httpSession.setAttribute("UserInfo", userInfo);			// Binds object with an attribute
	}
	
	
	/**
	 * clears session info once logged off
	 * @param request
	 */
	public void clearAttributeFromSession(HttpServletRequest request) 
	{
		HttpSession httpSession = request.getSession(true);
		httpSession.invalidate();
	}
	

	/**
	 * sets Pending connection info in session
	 * @param request
	 * @param userInfo
	 */
	public void setPendingRequestInSession(HttpServletRequest request, UserInfo userInfo)
	{
			List<RequestObject> pendingRequestList = chatLogic.getPendingRequestList(userInfo.getUserid());
			
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("PendingRequestList", pendingRequestList);
	}
	
	/**
	 * Sets accepted connection info in session.
	 * @param request
	 * @param userInfo
	 */
	public void setAcceptedRequestInSession(HttpServletRequest request, UserInfo userInfo) 
	{
			List<RequestObject> AcceptedRequestList = chatLogic.getAcceptedRequestList(userInfo.getUserid());
			
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("AcceptedRequestList", AcceptedRequestList);

		
	}

	
	public void initChatBox(HttpServletRequest request, int loginUserid, int chatUserid, String chatUserName) throws ServletException
	{
			List<MessageObject> list = getChatBoxList(request, loginUserid, chatUserid,chatUserName);
    	
			Map<String,List> map = null;
		
			if(null == list)
			{
    		
				String chatBoxKey = ""+loginUserid+chatUserid;		//if list is null then create new chatboxkey and set in session
    		
				setChatBoxKeyInSession(request, chatUserName, chatBoxKey);
        
				map = getChatBox();
				list = new ArrayList<MessageObject>();

				map.put(chatBoxKey, list);
			}
	}	
	
	
	
	
	public List getChatBoxList(HttpServletRequest request, Integer loginUserid,Integer chatUserid,String chatUserName) throws ServletException {

    	Map<String,List> map = getChatBox();
    	List<MessageObject> list = null;
    	
    	if(null != map)
    	{
	    	String chatBoxKey1 = ""+loginUserid+chatUserid;
	    	String chatBoxKey2 = ""+chatUserid+loginUserid;
	    	
	    	list =  map.get(chatBoxKey1);
	    	
	    	if(null != list)
	    	{
	    		
	    		setChatBoxKeyInSession(request, chatUserName, chatBoxKey1);
	    		
	    	}
	    	else
	    	{
	    		list =  map.get(chatBoxKey2);
	    		
	    		if(null != list)
	    		{
		    		
		    		setChatBoxKeyInSession(request, chatUserName, chatBoxKey2);
		    		
		    	}
	    	}
	    	
    	}
		return list;
		
    }
	
	
	
	public Map<String, List> getChatBox()
	{
		
		Map<String, List> map = null;
		ServletContext servletContext = getServletContext();
		
		map = (Map<String, List>) servletContext.getAttribute("ChatBox");
		
			if(null != map)
			{
				return map;
			}
			else
			{
				map = new HashMap<String,List>();
				servletContext.setAttribute("ChatBox",map);
				return map;
			}
				
	}
	
	
	
	private void setChatBoxKeyInSession(HttpServletRequest request,String chatUserName, String chatBoxKey) 
	{
		HttpSession httpSession = request.getSession(true);
		
    	httpSession.setAttribute("ChatBoxKey", chatBoxKey);
		
		httpSession.setAttribute("ChatBoxUserName", chatUserName);
	}
	
	
	 public List getChatBoxItems(HttpServletRequest request, String key) throws ServletException
	 {

	    	Map<String,List> map = getChatBox();
	    	List<MessageObject> list = null;
	    	
	    	if(null != map)
	    	{	    	
		    	list =  map.get(key);
	    	}
			return list;
			
	 }
	 
	 
	 public void logOutUser(HttpServletRequest request) 
	 {
			UserInfo userInfo = getUserInfoFromSession(request);

			if (null != userInfo) 
			{
				
				try 
				{
					adminLogic.updateStatus(userInfo.getUserid(), StatusConstants.LOGGEDOFF);
				}
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				clearAttributeFromSession(request);
			}
	 }
}
