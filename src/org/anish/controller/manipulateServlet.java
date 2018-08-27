package org.anish.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anish.business.PaymentProcess;
import org.anish.hibernate.dto.carsDB;
import org.apache.log4j.Logger;

public class manipulateServlet extends HttpServlet{
	Logger log=Logger.getLogger(Logger.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res){}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		String pickupDate=req.getParameter("pickupDate");
		String returnDate=req.getParameter("returnDate");
		String receiptnumber=req.getParameter("receiptnumber");
		String deleteReceiptnumber=req.getParameter("deleteSchedule");
		
		log.info("pickup date : "+pickupDate);
		log.info("return date : "+returnDate);
		log.info("receiptnumber : "+receiptnumber);
		 if(pickupDate!=null && pickupDate!=""){
			log.info("pickupDate : "+pickupDate);
			try {
				pickupDateProcess(req,res,pickupDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}else if(returnDate!=null && returnDate!=""){
			log.info("returnDate : "+returnDate);
			try {
				returnDateProcess(req,res,returnDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		
		}else if(receiptnumber!=null && receiptnumber!=""){
			log.info("receipt number : "+receiptnumber);
			deleteProcess(req,res,receiptnumber);
		}
	}
	
	public void deleteProcess(HttpServletRequest req, HttpServletResponse res,String receiptnumber) throws ServletException, IOException{
		boolean deleteResult;
		log.info(PaymentProcess.deleteSchedule(receiptnumber));			
			deleteResult = PaymentProcess.deleteSchedule(receiptnumber);

		if(deleteResult){
			log.info("deleteResult : "+deleteResult);
			req.setAttribute("rc","Your Schedule has been deleted....! ");
			RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
			dispatcher.forward(req, res);
		}else{
			log.info("deleteResult : "+deleteResult);
			req.setAttribute("rc","your schedule has been deleted, try one more time.");
			RequestDispatcher dispatcher=req.getRequestDispatcher("manageSchedule.jsp");
		}
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
}
