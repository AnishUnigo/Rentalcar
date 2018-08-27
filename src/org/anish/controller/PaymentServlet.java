package org.anish.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anish.business.PaymentProcess;
import org.anish.jdbc.rentalCarDB;
import org.apache.log4j.Logger;

public class PaymentServlet extends HttpServlet{
	Logger log=Logger.getLogger(PaymentServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try {
			guestProcess(req,res);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String username=req.getParameter("user");
		String email=req.getParameter("email");
		log.info("doPost user name : "+username);
		log.info("doPost guest email : "+email);
		if(username!=null && username!=""){
			try {
				userProcess(req,res);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}else if(email!=null && email!=""){
		try {
			guestProcess(req,res);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		}
	}
	public void guestProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException{
		
		log.info(" entered in  guestProcess method");
		/*--------------- Driver Information --------------------------*/
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String confirmemail=req.getParameter("confirmemail");
		String phonenumber=req.getParameter("phonenumber");
		log.info("first Name : "+firstname);
		log.info("phone number : "+phonenumber);
		
		/*-----------------------Credit card info ----------------------*/
		String creditcardnumber=req.getParameter("creditcardnumber");
		String months=req.getParameter("month");
		String year=req.getParameter("year");
		int year1=Integer.parseInt(year);
		String cvv=req.getParameter("cvv");
		int cvv1=Integer.parseInt(cvv);
		log.info("credit card number : "+creditcardnumber);
		log.info("Month : "+months);
		
		/*---------------------  car details ---------------------------*/
		String carName=req.getParameter("carName");
		String carType=req.getParameter("carType");
		String fuelType=req.getParameter("fuelType");
		String pickupdate=req.getParameter("pickupdate");
		String returndate=req.getParameter("returndate");
		String days=req.getParameter("days");
		String tax=req.getParameter("tax");
		String includingTax=req.getParameter("includingTax");
		int includingTaxC=Integer.parseInt(includingTax);
		log.info(" Guest car Name : "+carName);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date beginDate = dateFormat.parse(pickupdate);
		Date endDate = dateFormat.parse(returndate);

		/*---------------------   calling PaymentProcess --------------------*/
		
		if(email!=null){
			Random randomGenerator = new Random();
			log.info("randome number : "+randomGenerator.nextInt(500));
			String rc="RC-"+randomGenerator.nextInt(999);
			
			log.info("generated receipt number for guest : "+rc);
			
			boolean guestResult=rentalCarDB.insertGuestDetails(firstname, lastname, email, phonenumber);
			if(guestResult){
				log.info("guest insert details : "+guestResult);
				boolean paymentResult=PaymentProcess.insertPayment(creditcardnumber, months, year1, cvv1,rc);
				if(paymentResult){
					log.info("payment result : "+paymentResult);
					boolean carEntryResult=PaymentProcess.guestCarDetails(firstname, carName, carType, fuelType, beginDate, endDate, days, includingTaxC, rc);
					if(carEntryResult){
					req.setAttribute("firstname", firstname);
					req.setAttribute("phonenumber", phonenumber);
					req.setAttribute("includingTax", includingTax);
					req.setAttribute("receiptNumber", rc);
					RequestDispatcher dispatcher=req.getRequestDispatcher("paymentConfirmation.jsp");
					dispatcher.forward(req, res);
					}else{
						log.info("carEntryResult result : "+carEntryResult);
						RequestDispatcher dispatcher=req.getRequestDispatcher("bookingResponse.jsp");
						dispatcher.forward(req, res);
					}
				}else{
					log.info("payment result : "+paymentResult);
					RequestDispatcher dispatcher=req.getRequestDispatcher("bookingResponse.jsp");
					dispatcher.forward(req, res);
				}
				
			}else{
				log.info("guest insert details : "+guestResult);
			}
			
			
		}else{
			
		}
		
		
	}

	public void userProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException{
		
		/*-----------------------Credit card info ----------------------*/
		try{
		log.info("entered userProcess Method of PaymentServlet");
		String creditcardnumber=req.getParameter("creditcardnumber");
		String month=req.getParameter("month");
		String year=req.getParameter("year");
		int yearC=Integer.parseInt(year);
		String cvv=req.getParameter("cvv");
		int cvv1=Integer.parseInt(cvv);
		log.info("credit card number : "+creditcardnumber);
		log.info("Month : "+month);
		
		/*---------------------  car details ---------------------------*/
		String carName=req.getParameter("carName");
		String carType=req.getParameter("carType");
		String fuelType=req.getParameter("fuelType");
		String pickupdate=req.getParameter("pickupdate");
		String returndate=req.getParameter("returndate");
		String days=req.getParameter("days");
		String tax=req.getParameter("tax");
		String includingTax=req.getParameter("includingTax");
		
		int includingTaxC=Integer.parseInt(includingTax);
		
		log.info(" userProcess car Name : "+carName);
		log.info(" userProcess Including Tax : "+includingTax);
		
		// user name
		String username=req.getParameter("user");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date beginDate = dateFormat.parse(pickupdate);
		Date endDate = dateFormat.parse(returndate);
		
		if(username!=null && username!=""){
		
		Random randomGenerator = new Random();
		log.info("randome number : "+randomGenerator.nextInt(999));
		String rc="RC-"+randomGenerator.nextInt(500);
		log.info("generated receipt number for user : "+rc);
		
		boolean carEntryResult=PaymentProcess.userCarDetails(username, carName, carType, fuelType, beginDate, endDate, days, includingTaxC, rc);
		if(carEntryResult){
			log.info(" userProcess car entry result : "+carEntryResult);
			
			boolean paymentResult=PaymentProcess.userPayment(username, creditcardnumber, month, yearC, cvv1, rc);
			log.info("in userProcess method paymentResult : "+paymentResult);
			if(paymentResult){
				log.info("in userProcess method paymentResult : "+paymentResult);
				req.setAttribute("username", username);
				req.setAttribute("includingTax", includingTax);
				req.setAttribute("receiptNumber", rc);
				RequestDispatcher dispatcher=req.getRequestDispatcher("paymentConfirmation.jsp");
				dispatcher.forward(req, res);
			}else{
				
				log.info("in userProcess method paymentResult : "+paymentResult);
				RequestDispatcher dispatcher=req.getRequestDispatcher("bookingResponse.jsp");
				dispatcher.forward(req, res);
				
			}
		}else{
			
			log.info(" userProcess method car entry result : "+carEntryResult);
			
		}
		
		}else{
			
		}
		}catch(NumberFormatException  nfe){nfe.printStackTrace();
		}catch(Exception e){e.printStackTrace();
		}
	}
}

