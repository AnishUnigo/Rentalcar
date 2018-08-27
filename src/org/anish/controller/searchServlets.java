package org.anish.controller;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class searchServlets extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		process(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		process(req,res);
	}
	
	public void process(HttpServletRequest req,HttpServletResponse res)
	{
		try{
				String location=req.getParameter("location");
				String pickup=req.getParameter("pickup");
				String dropoff=req.getParameter("dropoff");
				if(location!=""){
					/*res.sendRedirect("welcome.html");*/
					PrintWriter writer= res.getWriter();
					writer.print("success");
					writer.close();
				}else if(location.equals("")){
					/*res.sendRedirect("error.html");*/
					PrintWriter writer= res.getWriter();
					writer.print("error");
					writer.close();
				}
				
				
			}
		
	catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}