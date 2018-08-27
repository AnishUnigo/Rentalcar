package org.anish.controller;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anish.business.searchCars;

public class searchCarServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		process(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		process(req,res);
		
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res){
			
		String carname=req.getParameter("searchCars");
		String cartype=req.getParameter("cartype");
		String fueltype=req.getParameter("fueltype");
		String carnameis=req.getParameter("carnameis");
		
		System.out.println("in servlets carname " +carname);
		System.out.println("in servlets car type " +cartype);
		System.out.println("in servlets fuel type " +fueltype);
		System.out.println("in servlets carname fron javascript " +carnameis);
		
		try{
		searchCars cars=new searchCars();
		boolean result=cars.findcars(carname, cartype, fueltype);
		if(result){
			PrintWriter writer=res.getWriter();
			
			writer.print("matched");
			res.sendRedirect("welcomeCars.html");
		// need to start from here
		}else{
			PrintWriter writer=res.getWriter();
			writer.print("notmatched");
		
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
