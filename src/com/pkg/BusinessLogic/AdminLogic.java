package com.pkg.BusinessLogic;

import java.sql.SQLException;
import java.util.List;

import com.pkg.DataAccessObject.AdminDataAccess;
import com.pkg.DataTransferObject.UserInfo;

public class AdminLogic 
{
	
	public boolean UserExists(String username) throws SQLException
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		UserInfo userInfo = adminDataAccess.getUser(username);
		return (null != userInfo);
	}
	
	public boolean saveUser(String firstname, String lastname, String email, String password) throws SQLException
	{
				boolean userSaved;
				AdminDataAccess adminDataAccess = new AdminDataAccess();
				userSaved = adminDataAccess.saveUser(firstname,lastname,email,password); // return true if data successfully saved
				
				return userSaved;		
	}
	
	
	public boolean updateStatus(int userId, int status) 
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.updateStatus(userId, status);
	}
	
	
		// userEmail is equivalent to user name
	public UserInfo getUserInfo(String userEmail) throws SQLException
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getUser(userEmail);
	}
	
	
	public List<UserInfo> searchUsers(String username) throws SQLException
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		List<UserInfo> userInfos = adminDataAccess.searchUser(username);
		
		return userInfos; 
	}
}
