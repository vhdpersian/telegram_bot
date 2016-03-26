package com.telegram.utils;

import java.sql.Connection;
import java.sql.SQLException;


public class DatasourceHelper {
	
	private Connection conn=null;
	private java.sql.PreparedStatement preparedStatement = null;
	
	private static DatasourceHelper ds=null;
	private DatasourceHelper()
	{
		conn=ConnectionHelper.getInstance();
	}
	public static DatasourceHelper getInstance()
	{
		if (ds==null)
		{
			ds=new DatasourceHelper();
		}
		return ds;
	}
	
	public void InsertUser(long chat_userId,String first_name,String last_name)
	{
		try {
			preparedStatement = conn.prepareStatement("insert into telegram.users values (default,?,?,?,?,?)");
			
			  // "user_id, chat_userId, date_created, date_update,first_name,last_name
		
			  preparedStatement.setString(1,Long.toString(chat_userId));
			  preparedStatement.setString(2,null);
			  preparedStatement.setString(3,null);
			  preparedStatement.setString(4,first_name);
			  preparedStatement.setString(5,last_name);

		   		      
			  preparedStatement.executeUpdate();
			  
			  preparedStatement.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		    

		
	}
	

}
