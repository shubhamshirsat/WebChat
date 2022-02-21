package com.pkg.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection 
{
	
	
			//Static connection reference created
			static private Connection connection = null;

			/**
			 * @return connection object
			 */
			
			public static Connection getConnectionObject() 
			{
				try 
				{
						if(null != connection && !connection.isClosed())
						{
						
						}
						else
						{
						
							try 
							{
								//load driver class in JVM
								Class.forName("oracle.jdbc.driver.OracleDriver");

							}
							catch (ClassNotFoundException e) 
							{
								e.printStackTrace();	
							}

							try 
							{
								// created connection below and retrived connection object
								connection = DriverManager.getConnection(
									"jdbc:oracle:thin:@localhost:1521:xe", "System",
									"Oracle");

							}
							catch (SQLException e)
							{
								e.printStackTrace();
							}
						
						}				// end of else....
					
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return connection;			//		Data base Connection object returned
				
			}			// method end.........
			
}				// class end........


