package org.anish.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anish.jdbc.DBConnection;
import org.anish.jdbc.rentalCarDB;

public class searchSubmit extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		
		try {
			process(req,res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		try {
			process(req,res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void process(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException,Exception{
		
		String location= req.getParameter("location");
		String pickupD= req.getParameter("pick-up");
		String pickupT= req.getParameter("picktime");
		String returnD= req.getParameter("returning");
		String returnT= req.getParameter("returntime");
		System.out.println(location);
		
		
	}
}