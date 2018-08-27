package org.anish.jdbc;

import java.sql.Connection;


public class TestDBCalls {

	public static void main(String args[]) throws Exception
	{
		
		Connection conn=DBConnection.getDBConnection("mysql");
		try{
		conn.setAutoCommit(false);
		//UsersTable.insertUser("javaclient111", "javaclient111", "java", conn);
		//UsersTable.updatePwd("javaclient", "new_password", conn);
		//UsersTable.deleteUser("javaclient", conn);
		//UsersTable.getUsersByCopmany("3", conn);
				
		conn.commit();
		}catch(Exception e)
		{
			conn.rollback();
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
}
