package org.anish.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anish.business.PaymentProcess;
import org.anish.hibernate.dto.carsDB;
import org.anish.hibernate.dto.userDetails;
import org.anish.jdbc.DBConnection;
import org.anish.jdbc.rentalCarDB;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class registerServlet extends HttpServlet{
	Logger log=Logger.getLogger(registerServlet.class);
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		String username=req.getParameter("username");
		if(username!=null){
			gobackProcess(req,res);
		}else{
		
		try {
			process(req,res);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		}
		
	}
	public void process(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException,Exception{
		
		
		log.info("enterred in process method");
		
			/*---------------- from register field ------------------- */
			String firstname=req.getParameter("firstName");
			String lastname=req.getParameter("lastName");
			String fandl=firstname+lastname;
			String fullname= req.getParameter("fullname");
			String email=req.getParameter("email");
			String dob=req.getParameter("date");
			String sex=req.getParameter("sex");
			String mobile=req.getParameter("mobile");
			String password=req.getParameter("password");
			String retype=req.getParameter("retype");
			String userid=req.getParameter("userid");
			
			
			/* --------------- from REGISTER page --------------- */
			if(userid!="" && dob!=null){
				log.info("userid from register form : "+userid);
			try{
			boolean result=rentalCarDB.insertUserDetails(firstname,lastname,email,dob,sex,mobile,password,retype,fandl,userid);
			if(result){
				log.info("registerd result : "+ result);
				res.sendRedirect("index.jsp");
			}else{
				log.info("registerd result : "+ result);
				res.sendRedirect("register.html");
			}
		}catch(Exception e){
			e.printStackTrace();
			}
		}
			/*---------------- from LOGIN field ---------------------*/
			String ajaxloginemail=req.getParameter("loginemail");
			String loginemail=req.getParameter("email");
			String loginpswd=req.getParameter("loginpswd");
			// from onclick ajax event 'pswdBtn'
			String pswdBtn=req.getParameter("pswdBtn");
			/* ---------------- inputs from login form emailId and PassWord -------------- */
			
			String jsonSuccessRes= "";
			jsonSuccessRes+="{\n";
			jsonSuccessRes+="\"password_check\":\"exist\"\n";
			jsonSuccessRes+="}\n";
			
			String jsonFailedRes= "";
			jsonFailedRes+="{\n";
			jsonFailedRes+="\"password_check\":\"not_exists\"\n";
			jsonFailedRes+="}\n";
			
			log.info("get parameter of loginemail : "+loginemail);
			log.info("get parameter of loginpswd : "+loginpswd);
			
			try{
				if(!loginemail.equals(null) && !loginpswd.equals(null)){
					log.info("get parameter of loginemail : "+loginemail);
					log.info("get parameter of loginpswd : "+loginpswd);
					res.setContentType("application/json");
					log.info("entered in if block of loginemail, loginpswd in servlet : "+loginemail+" , "+loginpswd);
					log.info("password from Ajaxcall by clicking submit button :"+loginpswd);
					boolean result=rentalCarDB.signInCheck(loginemail,loginpswd);
					if(result){
						
						userDetails userdetails= rentalCarDB.retrieveUserName(loginemail);
						
						req.setAttribute("username", userdetails.getFirst_name());
						log.info("user name : "+userdetails.getFirst_name());
						log.info("loginemail and loginpswd result : "+result);
						
						try{
						RequestDispatcher dispatcher=req.getRequestDispatcher("selectCars.jsp");
						log.info("dispatching.....");
						/*res.sendRedirect("selectCars.jsp");*/
						dispatcher.forward(req, res);
						log.info("after forwarding dispatcher "+dispatcher);
						}catch(Exception e){e.printStackTrace();}
					}else{
						log.info("loginemail and AjaxpswdBtn result : "+result);
						/*PrintWriter writer=res.getWriter();
						log.info("jsonFailedRes : "+jsonFailedRes);
						writer.print(jsonFailedRes);*/
						String incorrect="email or password incorrect";
						req.setAttribute("incorrect", incorrect);
						RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
						dispatcher.forward(req, res);
					}
				}
			}catch(Exception e){
				
			}
			
		/* --------------from ajax LOGIN EMAIL input ----------- */
		 try{
			if(!ajaxloginemail.equals(null)){
				log.info("entered in if block of ajaxloginemail in servlet : "+ajaxloginemail);
				
				boolean result=rentalCarDB.validateUserLoginEmail(ajaxloginemail);
				if(result){
					System.out.println("AjaxLoginEmail Result : "+result);
					PrintWriter writer=res.getWriter();
					writer.print("matched");
					
				}else{
					System.out.println("AjaxLoginEmail result : "+result);
					PrintWriter writer=res.getWriter();
					writer.print("failed");
				}
			}
		}catch(Exception e){}
	
		
	
	}
	
	public void gobackProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String username = req.getParameter("username");
		
		req.setAttribute("username", username);
		log.info("page redirect to selectCars.jsp with username : "+username);
		RequestDispatcher dispatcher=req.getRequestDispatcher("selectCars.jsp");
		dispatcher.forward(req, res);
	}
}

