package org.anish.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.istack.internal.logging.Logger;


public class SelectCarServlet extends HttpServlet{
	Logger log= Logger.getLogger(SelectCarServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {
			process(req,res);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			String location=req.getParameter("locations");
			String ipickupdate=req.getParameter("indexPickupDate");
			String ireturndate=req.getParameter("indexReturnDate");
			log.info("location : "+location);
			
			if(location!=null){
				locationProcess(req,res);
			}else if(ipickupdate!=null && ireturndate!=null){
				iDates(req,res);
			
			}else{
				process(req,res);
			}
			
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException,Exception{
		log.info("entered in process method");
		
		try{
		/* ------------------ from selectCars.jsp -------------------*/
		String carName=req.getParameter("carname");
		String carType=req.getParameter("cartype");
		String fuelType=req.getParameter("fueltype");
		String carPrice=req.getParameter("carprice");
		int carPricevalue=Integer.parseInt(carPrice);
		String pickupdate=req.getParameter("pickupdate");
		String returndate=req.getParameter("returndate");
		String username=req.getParameter("username");
		log.info("carName : "+carName);
		log.info("carType : "+carType);	
		log.info("username : "+username);
		/*------------------------------------------------------------*/
		
		
		
		/*------------------------------------------------------------*/
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date beginDate = dateFormat.parse(pickupdate);
		Date endDate = dateFormat.parse(returndate);

		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(beginDate);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		
		int minusDays = 0;
		while (true) {
		  minusDays++;

		  // Day increasing by 1
		  beginCalendar.add(Calendar.DAY_OF_MONTH, 1);

		  if (dateFormat.format(beginCalendar.getTime()).
		            equals(dateFormat.format(endCalendar.getTime()))) {
		    break;
		  }
		}
		log.info("The substractation between two dates is " + (minusDays + 1));
		try{
		int days=(minusDays+1);
		log.info("minusdays "+minusDays);
		int multiprice=minusDays*carPricevalue;
		int tax=15;
		int includingTax=tax*multiprice;
		includingTax=includingTax/100;
		includingTax=includingTax+multiprice;
		log.info("includingTax"+includingTax);
		log.info("tax "+tax);
		
		/* --------- sending to bookingResponse.jsp ----------------*/
		req.setAttribute("username", username);
		req.setAttribute("carName", carName);
		req.setAttribute("carType", carType);
		req.setAttribute("fuelType", fuelType);
		req.setAttribute("carPrice", carPricevalue);
		req.setAttribute("pickupdate", pickupdate);
		req.setAttribute("returndate", returndate);
		req.setAttribute("days", days);
		req.setAttribute("multiprice", multiprice);
		req.setAttribute("tax", tax);
		req.setAttribute("includingTax", includingTax);
		/*req.setAttribute("days", days);*/
		}catch(Exception e){e.printStackTrace();}
		try{
		RequestDispatcher dispatcher= req.getRequestDispatcher("bookingResponse.jsp");
		log.info(" request dispatcher");
		dispatcher.forward(req, res);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		/* -------------------------------------------------------*/
		}catch(Exception e){
			
		    
		}
	}
	
	public void locationProcess(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		log.info("entered in locationProcess method");
		String location=req.getParameter("locations");
		String indexPickupDate= req.getParameter("pickdateI");
		String indexReturnDate= req.getParameter("returndateI");
		String picktime=req.getParameter("picktime");
		String returntime=req.getParameter("returntime");
		log.info("location : "+location);
		log.info("indexPickupDate : "+indexPickupDate);
		log.info("indexReturnDate : "+indexReturnDate);
		
		req.setAttribute("location", location);
		req.setAttribute("indexPickupDate", indexPickupDate);
		req.setAttribute("indexReturnDate", indexReturnDate);
		req.setAttribute("picktime", picktime);
		req.setAttribute("returntime", returntime);
		
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("selectCars.jsp");
		log.info(" request dispatcher");
		dispatcher.forward(req, res);
	}
	
	public void iDates(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException, ParseException{
	
		String ipickupdate=req.getParameter("indexPickupDate");
		String ireturndate=req.getParameter("indexReturnDate");
		String carName=req.getParameter("carname");
		String carType=req.getParameter("cartype");
		String fuelType=req.getParameter("fueltype");
		String carPrice=req.getParameter("carprice");
		int carPricevalue=Integer.parseInt(carPrice);
		
		
		log.info("carName : "+carName);
		log.info("carType : "+carType);	
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date beginDate = dateFormat.parse(ipickupdate);
		Date endDate = dateFormat.parse(ireturndate);

		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(beginDate);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		
		int minusDays = 0;
		while (true) {
		  minusDays++;

		  // Day increasing by 1
		  beginCalendar.add(Calendar.DAY_OF_MONTH, 1);

		  if (dateFormat.format(beginCalendar.getTime()).
		            equals(dateFormat.format(endCalendar.getTime()))) {
		    break;
		  }
		}
		log.info("The substractation between two dates is " + (minusDays + 1));
		try{
		int days=(minusDays+1);
		log.info("minusdays "+minusDays);
		int multiprice=minusDays*carPricevalue;
		int tax=15;
		int includingTax=tax*multiprice;
		includingTax=includingTax/100;
		includingTax=includingTax+multiprice;
		log.info("includingTax"+includingTax);
		log.info("tax "+tax);
		
		/* --------- sending to bookingResponse.jsp ----------------*/
		
		req.setAttribute("carName", carName);
		req.setAttribute("carType", carType);
		req.setAttribute("fuelType", fuelType);
		req.setAttribute("carPrice", carPricevalue);
		req.setAttribute("pickupdate", ipickupdate);
		req.setAttribute("returndate", ireturndate);
		req.setAttribute("days", days);
		req.setAttribute("multiprice", multiprice);
		req.setAttribute("tax", tax);
		req.setAttribute("includingTax", includingTax);
		/*req.setAttribute("days", days);*/
		}catch(Exception e){e.printStackTrace();}
		try{
		RequestDispatcher dispatcher= req.getRequestDispatcher("bookingResponse.jsp");
		log.info(" request dispatcher");
		dispatcher.forward(req, res);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		/* -------------------------------------------------------*/
		
	}
}
