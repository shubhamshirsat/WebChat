package com.pkg.BusinessLogic;

import java.sql.SQLException;
import java.util.List;

import com.pkg.DataAccessObject.ChatDataAccess;
import com.pkg.DataTransferObject.RequestObject;
import com.pkg.Utility.StatusConstants;

public class ChatLogic
{

	public List<RequestObject> getPendingRequestList(int userid) 
	{
		ChatDataAccess chatDataAccess = new ChatDataAccess();
		
		List<RequestObject> pendingList = null;
		List<RequestObject> sentRequestPendingList     = chatDataAccess.getSentRequestPendingList(StatusConstants.PENDING, userid);		// gets the pending request list in such a way that request has been sent but not yet Accepted
		List<RequestObject> recievedRequestPendingList = chatDataAccess.getRecievedRequestPendingList(StatusConstants.PENDING, userid);	// gets the pending request list in such a way that request has been recieved but not yet Accepted	
		
		pendingList = sentRequestPendingList;
		pendingList.addAll(recievedRequestPendingList);		// appends another list at the end of pending list
		
		return pendingList;									//  Return the whole pending request List...........
		
	}
	
	
	
	public List<RequestObject> getAcceptedRequestList(int userid) 
	{
		ChatDataAccess chatDataAccess = new ChatDataAccess();
		
		List<RequestObject> acceptedList = null;
		List<RequestObject> sentRequestAcceptedList = chatDataAccess.getSentRequestAcceptedList(StatusConstants.ACCEPTED, userid);
		List<RequestObject> recievedRequestAcceptedList = chatDataAccess.getRecievedRequestAcceptedList(StatusConstants.ACCEPTED, userid);
		
		acceptedList = sentRequestAcceptedList;
		acceptedList.addAll(recievedRequestAcceptedList);
		
		return acceptedList;
				
	}
	
	
	public Integer sendRequest(int requestorId, int acceptorId) 
	{
		ChatDataAccess chatDataAccess = new ChatDataAccess();
		Integer connectionStatus = null;
		
		connectionStatus =  chatDataAccess.getConnectionStatus(requestorId, acceptorId);
		
			if(connectionStatus == StatusConstants.NOTFOUND)
			{
				if(chatDataAccess.sendRequest(requestorId, acceptorId))
				{
					connectionStatus = StatusConstants.REQUESTSEND;
				}
			}
		 
		 return	connectionStatus;
		
	}
	
	
	
	public boolean acceptRequest(int acceptor_userid, int requestor_userid) 
	{
		
		ChatDataAccess chatDataAccess = new ChatDataAccess();
		boolean isAccepted = chatDataAccess.acceptRequest(acceptor_userid, requestor_userid);
		
		return isAccepted;
	}
}
