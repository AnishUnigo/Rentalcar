package org.anish.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class logoutServlet extends HttpServlet{
	Logger log=Logger.getLogger(logoutServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res){}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		String username=req.getParameter("username");
		log.info("logout username : "+username);
		if(username!=null && username!=""){
			HttpSession session=req.getSession();
			session.invalidate();
			res.sendRedirect("index.jsp");
		}
	}
}
