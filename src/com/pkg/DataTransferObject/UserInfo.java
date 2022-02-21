package com.pkg.DataTransferObject;

public class UserInfo
{
	private int userid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int status;
	
	
	public int getUserid()
	{
		return userid;
	}
	
	public void setUserid(int userid) 
	{
		this.userid = userid;
	}
	
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
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public int getStatus() 
	{
		return status;
	}
	
	public void setStatus(int status) 
	{
		this.status = status;
	}
	
	
}
