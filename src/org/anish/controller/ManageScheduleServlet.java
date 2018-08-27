package org.anish.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.anish.business.PaymentProcess;
import org.anish.hibernate.dto.carsDB;
import org.apache.log4j.Logger;

public class ManageScheduleServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(ManageScheduleServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{ 
		String username=req.getParameter("username");
		log.info("username : "+username);
		if(username!=null){
		usernameProcess(req,res,username);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		String receiptNumber=req.getParameter("receiptnumber");
		String deleteReceiptnumber=req.getParameter("deleteSchedule");
		String byname=req.getParameter("byname");
		String pickupDate=req.getParameter("pickupDate");
		String returnDate=req.getParameter("returnDate");
		
		log.info("receiptNumber : "+receiptNumber);
		
		if(receiptNumber!=null){
			log.info("receiptnumber : "+receiptNumber);
			receiptNumberProcess(req,res,receiptNumber);
		}else if(pickupDate!=null){
			log.info("pickupDate : "+pickupDate);
			try {
				pickupDateProcess(req,res,pickupDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}else if(returnDate!=null){
			log.info("returnDate : "+returnDate);
			try {
				returnDateProcess(req,res,returnDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}
		
/*carsDB cars=PaymentProcess.retreiveCarDetails(receiptnumber);
		
		String carname= "{\n";
		carname+="\"carname\" : "+cars.getCarName()+"\n";
		carname+="}";
		
		String carprice= "{\n";
		carprice+="\"carprice\" : "+cars.getCarPrice()+"\n";
		carprice+="}";*/
	}
	public void receiptNumberProcess(HttpServletRequest req, HttpServletResponse res, String receiptNumber) throws ServletException, IOException{
		
		
			if(receiptNumber!=null){
				carsDB cars=PaymentProcess.receiptNumber(receiptNumber);
				log.info("carname : "+cars.getCarName());
				
				if(cars!=null){
					req.setAttribute("carname", cars.getCarName());
					req.setAttribute("cartype", cars.getCartype());
					req.setAttribute("pickupdate", cars.getPickupDate());
					req.setAttribute("returndate", cars.getReturnDate());
					req.setAttribute("carprice", cars.getCarPrice());
					req.setAttribute("receiptResult", cars.getReceiptnumber());
				
					RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
					dispatcher.forward(req, res);
				
				}
			
			}else{
				res.sendRedirect("manageSchedule.jsp");
			}
		
		/*try{
			if(byname!=null){
				carsDB cars=PaymentProcess.byName(byname);
				log.info(""+cars.getCarName());
				req.setAttribute("carname", cars.getCarName());
				req.setAttribute("cartype", cars.getCartype());
				req.setAttribute("pickupdate", cars.getPickupDate());
				req.setAttribute("returndate", cars.getReturnDate());
				req.setAttribute("carprice", cars.getCarPrice());
				req.setAttribute("rc", cars.getReceiptnumber());
				
				try{
				RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
				dispatcher.forward(req, res);
				}
				
				
				catch(Exception e)
				{e.printStackTrace();
				}
				
			} 
			
		}catch(Exception e){}*/
	}
	public void pickupDateProcess(HttpServletRequest req, HttpServletResponse res, String pickupDate) throws ServletException, IOException, ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyy-mm-dd");
		Date beginDate = dateFormat.parse(pickupDate);
		carsDB carlist=PaymentProcess.updatePickupSchedule(beginDate);
		if(carlist!=null){
			log.info("pickup date scheduled to : "+carlist.getPickupDate());
			req.setAttribute("modifiedPickupDate", carlist.getPickupDate());
			RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
			dispatcher.forward(req, res);
		}else{
			req.setAttribute("notModifiedPickup", carlist.getPickupDate());
			RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
			dispatcher.forward(req, res);
		}
	}
	public void returnDateProcess(HttpServletRequest req, HttpServletResponse res, String returnDate) throws ServletException, IOException, ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyy-mm-dd");
		Date endDate = dateFormat.parse(returnDate);
		carsDB carlist=PaymentProcess.updateReturnSchedule(endDate);
		if(carlist!=null){
			log.info("retun date scheduled to : "+carlist.getReturnDate());
			req.setAttribute("modifiedReturnDate", carlist.getPickupDate());
			RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
			dispatcher.forward(req, res);
		}else{
			req.setAttribute("notModifiedReturn", carlist.getReturnDate());
			RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
			dispatcher.forward(req, res);
		}
	}
	public void usernameProcess(HttpServletRequest req, HttpServletResponse res,String username) throws IOException, ServletException{
			
		log.info("entered into usernameProcess : "+username);
		PrintWriter writer=res.getWriter();
		writer.print(username);
		
	}
}
			
		
				
			
			
		

		

