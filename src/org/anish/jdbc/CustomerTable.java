package org.anish.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTable {


	public static boolean isValidUser(String userid, String password,Connection conn) throws SQLException 
    {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        boolean result=false;
        try
        {
        	stmt = conn.prepareStatement("select userid from customer where userid=? and password=?");
            stmt.setString(1, userid);
            stmt.setString(2, password);
    		
            resultSet = stmt.executeQuery();
            if (resultSet.next())
            {
            	String s=resultSet.getString(1);
            	System.out.println(s);
            	result=true;
            }
            else
            	result=false;
            
        }
        catch (SQLException e)
        {
        	e.printStackTrace();
            throw e;
        }
        finally
        {
        	try{
        		resultSet.close(); } catch(SQLException s){}
            try{
            	stmt.close();} catch(SQLException s){}
        }
        
        return result;
    }

	
}

