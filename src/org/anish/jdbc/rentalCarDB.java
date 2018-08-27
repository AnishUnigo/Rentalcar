package org.anish.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import org.anish.hibernate.dto.Location;
import org.anish.hibernate.dto.carsDB;
import org.anish.hibernate.dto.userDetails;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class rentalCarDB {
	
	private String email;
	private String loginpswd;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginpswd() {
		return loginpswd;
	}

	public void setLoginpswd(String loginpswd) {
		this.loginpswd = loginpswd;
	}
	
	private static Logger log=Logger.getLogger(rentalCarDB.class);	
	
	static SessionFactory sessionFactcory = new Configuration().configure().buildSessionFactory();
	
	public static boolean insertUserDetails(String first_name, String last_name,String email, String dob,String sex, String mobile_number,String password, String retype_pswd,String fullname,String user_id){
		log.info("entered in insertUserDetails method ");
		Session session = sessionFactcory.openSession();
		
		userDetails user=new userDetails();
		boolean result = false;
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setEmail(email);
		user.setDob(dob);
		user.setSex(sex);
		user.setMobile_number(mobile_number);
		user.setPassword(password);
		user.setRetype_pswd(retype_pswd);
		user.setFullname(fullname);
		user.setUser_id(user_id);
		log.info("first_name from register form : "+first_name);
		log.info("Dob from regiaster form : "+dob);
		try{
			log.info("beginTransaction .....");
		session.beginTransaction();
		try{
		session.save(user);
		session.getTransaction().commit();
		}catch(Exception e){e.printStackTrace();}
		log.info("end of try block of insertUserDetails method rentalCarDB");
		result=true;
		return result;
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}
	
	public static boolean validateUserLoginEmail(String ajaxloginemail){
		
		Session session = sessionFactcory.openSession();
		
		userDetails user=new userDetails();
		boolean result = false;
		
			
		try{
			System.out.println("entered in try block of rentalCarDB"+ajaxloginemail);
		session.beginTransaction();
		try{
			Criteria criteria = session.createCriteria(userDetails.class);
			criteria.add(Restrictions.eq("email", ajaxloginemail));
			
			System.out.println("in rentalCarDB email : "+ajaxloginemail);
			
			user = (userDetails) criteria.uniqueResult();
			System.out.println("in rentalCarDB class : "+criteria.uniqueResult());	
			if(user!=null){
				System.out.println(" result : " +true);
				return true;
			}else{
				return false;
			}
		
		}catch(Exception e){e.printStackTrace();}
		System.out.println("end of try block of rentalCarDB"+ajaxloginemail);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}
	public static boolean signInCheck(String email, String loginpswd){
		Session session = sessionFactcory.openSession();
		userDetails user=new userDetails();
		boolean result = false;
		try{
			System.out.println("entered in try block of rentalCarDB_SigninCheck : "+email+loginpswd);
		session.beginTransaction();
		try{
			Criteria criteria = session.createCriteria(userDetails.class);
			criteria.add(Restrictions.eq("email", email));
			criteria.add(Restrictions.eq("password", loginpswd));
			System.out.println("in rentalCarDB_signinCheck email : "+email);
			System.out.println("in rentalCarDB_signinCheck password : "+loginpswd);
			user = (userDetails) criteria.uniqueResult();
			System.out.println("in rentalCarDB class : "+criteria.uniqueResult());	
			if(user!=null){
				System.out.println(" in rentalcarDB_signinCheck result : " +true);
				return true;
			}else{
				return false;
			}
		
		}catch(Exception e){e.printStackTrace();}
		System.out.println("end of try block of rentalCarDB_signinCheck : "+email+" ,"+loginpswd);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}
	public static userDetails retrieveUserName(String loginemail){
		Session session = sessionFactcory.openSession();
		userDetails user=new userDetails();
		
		try{
			System.out.println("entered in try block of rentalCarDB_SigninCheck : "+loginemail);
			session.beginTransaction();
		try{
			Criteria criteria = session.createCriteria(userDetails.class);
			criteria.add(Restrictions.eq("email", loginemail));
		
			log.info(" in rentalCarDB_retrieveUserName email : "+loginemail);
			user = (userDetails) criteria.uniqueResult();
			log.info("in rentalCarDB class : "+criteria.uniqueResult());	
			if(user!=null){
				System.out.println(" in rentalCarDB_retrieveUserName result : " +true);
				return user;
			}else{
				return user;
			}
		
		}catch(Exception e){e.printStackTrace();}
		log.info("end of try block of rentalCarDB_retrieveUserName : "+loginemail);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
	}
	
	public static boolean insertLocation(String street, String city){
		Session session = sessionFactcory.openSession();
		Location loc=new Location();
		boolean result=false;
		loc.setCity(city);
		loc.setStreet(street);
		try{
			session.beginTransaction();
			session.save(loc);
			session.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
		
	}
	public static boolean insertGuestDetails(String firstName, String lastName, String email, String phonenummber){
		log.info("entered in insertGuestDetails method");
		Session session = sessionFactcory.openSession();
		
		userDetails user=new userDetails();
		boolean result = false;
		log.info("Guest first name : "+firstName);
		user.setUser_id(firstName);
		user.setFirst_name(firstName);
		user.setLast_name(lastName);
		user.setEmail(email);
		user.setMobile_number(phonenummber);
		user.setPassword(email);
		
		try{	
		log.info("begin transaction ........");
		session.beginTransaction();
		session.save(user);
		
		result=true;
		return result;
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			session.getTransaction().commit();
		}
		
		return result;
	}
	
	
}
