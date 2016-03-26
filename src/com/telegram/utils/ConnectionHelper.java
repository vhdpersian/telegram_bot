package com.telegram.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
	
	private static final String dcn="com.mysql.jdbc.Driver";
	private static final String  url="jdbc:mysql://localhost:3306/telegram";
	private static final String  user="root";
	private static final String  pass="toor";
	private static Connection conn=null;
	
    public static Connection getInstance()
    {
    	if (conn==null)
    	{
    		try {
				Class.forName(dcn).newInstance();
		        conn = DriverManager.getConnection(url, user, pass);
    		}
			catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			 catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	       		
    	}
    	return conn;
    	
    }
	

}
