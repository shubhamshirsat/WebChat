package com.pkg.DataTransferObject;

public class RequestObject
{
	String firstname;
	String lastname;
	Integer userid;
	String requestType;
	
	
	public String getFirstname() 
	{
		return firstname;
	}
	
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	public String getLastname() 
	{
		return lastname;
	}
	
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}
	
	public Integer getUserid() 
	{
		return userid;
	}
	
	public void setUserid(Integer userid) 
	{
		this.userid = userid;
	}
	
	public String getRequestType() 
	{
		return requestType;
	}
	
	public void setRequestType(String requestType) 
	{
		this.requestType = requestType;
	}
	
	
	
}
