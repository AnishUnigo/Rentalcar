package org.anish.business;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Connection;
import org.anish.hibernate.dto.CreditCard;
import org.anish.hibernate.dto.carsDB;
import org.anish.hibernate.dto.userDetails;
import org.anish.jdbc.DBConnection;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class PaymentProcess {
	
	static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	static Logger log=Logger.getLogger(PaymentProcess.class);
	public static boolean insertPayment(String cc_number, String month,int year,int cvv,String receiptNumber){
		
		Session session=sessionFactory.openSession();
		boolean result=false;
		try{
			
			CreditCard creditcard=new CreditCard();
			creditcard.setCc_number(cc_number);
			creditcard.setMonth(month);
			creditcard.setYear(year);
			creditcard.setCvv(cvv);
			creditcard.setReceiptNumber(receiptNumber);
			
			session.beginTransaction();
			session.save(creditcard);
			session.getTransaction().commit();
			
			result=true;
			
			return result;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean userPayment(String username, String cc_number, String month,int year,int cvv, String receiptNumber){
		log.info("entered userPayment method ");
		Session session=sessionFactory.openSession();
		boolean result=false;
		try
	    {
			
			CreditCard creditcard=new CreditCard();
			creditcard.setCc_number(cc_number);
			creditcard.setMonth(month);
			creditcard.setYear(year);
			creditcard.setCvv(cvv);
			creditcard.setReceiptNumber(receiptNumber);
			creditcard.setUsername(username);
			log.info("creditcard details : "+creditcard.getCc_number());
			log.info("begin transaction.......");
			session.beginTransaction();
			session.save(creditcard);
			session.getTransaction().commit();
			log.info("-----------end of transaction -----------");
			result=true;
			return result;
	    }catch(Exception e){e.printStackTrace();}
			return result;
	}
	public static boolean userCarDetails(String username,String carName,String carType,String fuelType,
			Date pickupdate,Date returndate,String days,int includingTax,String receiptNumber){
		log.info("entered userCarDetails method ");
		Session session=sessionFactory.openSession();
		boolean result=false;
		
		try{
		carsDB cars=new carsDB();
		cars.setCarName(carName);
		cars.setCartype(carType);
		cars.setCarFuelType(fuelType);
		cars.setPickupDate(pickupdate);
		cars.setReturnDate(returndate);
		cars.setCarPrice(includingTax);
		cars.setUsername(username);
		cars.setReceiptnumber(receiptNumber);
		log.info("cars db  car name : "+cars.getCarName());
		log.info("car receipt number : "+cars.getReceiptnumber());
		session.beginTransaction();
		session.save(cars);
		session.getTransaction().commit();
		result=true;
		return result;
		}catch(Exception e){e.printStackTrace();}
		return result;
	}
	public static boolean guestCarDetails(String firstname,String carName,String carType,String fuelType,
			Date pickupdate,Date returndate,String days,int includingTax,String receiptNumber){
		log.info("entered guestCarDetails method ");
		Session session=sessionFactory.openSession();
		boolean result=false;
		
		try{
		carsDB cars=new carsDB();
		cars.setCarName(carName);
		cars.setCartype(carType);
		cars.setCarFuelType(fuelType);
		cars.setPickupDate(pickupdate);
		cars.setReturnDate(returndate);
		cars.setCarPrice(includingTax);
		cars.setUsername(firstname);
		cars.setReceiptnumber(receiptNumber);
		log.info("cars db  car name : "+cars.getCarName());
		log.info("car receipt number : "+cars.getReceiptnumber());
		log.info("transaction begin .........");
		session.beginTransaction();
		session.save(cars);
		session.getTransaction().commit();
		result=true;
		return result;
		}catch(Exception e){e.printStackTrace();}
		return result;
	}
	public static carsDB retreiveCarDetails(String username){
		
		carsDB carlist = new carsDB();
		Session session = sessionFactory.openSession();
		try
        {
			
			session.beginTransaction();
			log.info(" retreiveCarDetails username : "+username);
			Criteria criteria = session.createCriteria(carsDB.class);
			criteria.add(Restrictions.eq("username", username));
			
			carlist = (carsDB) criteria.uniqueResult();
			System.out.println("in retreiveCarDetails  : "+criteria.uniqueResult());	
			if(carlist!=null){
				log.info("car name : "+carlist.getCarName());
				
				return carlist;
			}else{
				return carlist;
			}
		
        }catch(Exception e){e.printStackTrace();}
		return carlist;
		
	}
	public static carsDB receiptNumber(String rc){
		
		carsDB carlist = new carsDB();
		Session session = sessionFactory.openSession();
		try
        {	
			session.beginTransaction();
			log.info(" retreiveCarDetails with receipt number : "+rc);
			Criteria criteria = session.createCriteria(carsDB.class);
			criteria.add(Restrictions.eq("receiptnumber", rc));
			
			carlist = (carsDB) criteria.uniqueResult();
			System.out.println(" retreive scheduled list : "+criteria.uniqueResult());	
			if(carlist!=null){
				log.info("retreive schedule result : "+true);
				log.info(" carsDB carlist : "+carlist);
				log.info("car name : "+carlist.getCarName());
				return carlist;
			}else{
				log.info("retreive schedule result : "+false);
				log.info(" carsDB carlist : "+carlist);
				log.info("car name : "+carlist.getCarName());
				return carlist;
			}
        }catch(Exception e){e.printStackTrace();}
		return carlist;
	}
	
public static carsDB byName(String byname){
		
		carsDB carlist = new carsDB();
		Session session = sessionFactory.openSession();
		try
        {	
			String bname=byname;
			session.beginTransaction();
			//log.info(" retreiveCarDetails receit number : "+rc);
			Criteria criteria = session.createCriteria(carsDB.class);
			criteria.add(Restrictions.eq("receiptnumber", byname));
			
			carlist = (carsDB) ((Session) criteria).createQuery("FROM cars_db where bname in (:user_name)").list();
			System.out.println("in searchCars class : "+criteria.uniqueResult());	
			if(carlist!=null){
				log.info("car name : "+carlist.getCarName());
				return carlist;
			}else{
				return carlist;
			}
        }catch(Exception e){e.printStackTrace();}
		return carlist;
	}
	public static boolean deleteSchedule(String receiptnumber) {
		 
		carsDB carlist = new carsDB();
		boolean result=false;
		Session session = sessionFactory.openSession();
		try
        {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(carsDB.class);
			criteria.add(Restrictions.eq("receiptnumber", receiptnumber));
			carlist=(carsDB) criteria.uniqueResult();
			log.info("car id : "+carlist.getCarID());
			
			/*conn=DBConnection.getDBConnection("mysql");
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("delete from cars_db where receipt_number=?");
            stmt.setString(1, receiptnumber);
            int rowsupdated=stmt.executeUpdate();*/
			log.info("begin transaction ..........");
			
			carlist=(carsDB)session.get(carsDB.class, carlist.getCarID());
			session.delete(carlist);
			session.getTransaction();
			result=true;
			return result;
        }catch(Exception e){e.printStackTrace();}
			
			finally{
	
					session.close();
				
			}
		return result;
	}
	public static carsDB updatePickupSchedule(Date pickupDate) {
		carsDB carlist = new carsDB();
		boolean result=false;
		Session session = sessionFactory.openSession();
		try
        {
			session.beginTransaction();
			log.info(" receipt number to update pickupDate : "+pickupDate);
			log.info("pickupdate : ");
			carlist=(carsDB)session.get(carsDB.class, pickupDate);
			session.update(carlist);
			session.getTransaction();
			log.info("pickupdate changed to : "+carlist.getPickupDate());
			return carlist;
			
        }catch(Exception e){e.printStackTrace();}
			
			finally{
				session.close();
			}
		return carlist;
	}
	public static carsDB updateReturnSchedule(Date returnDate) {
		carsDB carlist = new carsDB();
		boolean result=false;
		Session session = sessionFactory.openSession();
		try
        {
			session.beginTransaction();
			log.info(" receipt number to update returnDate : "+returnDate);
			
			carlist=(carsDB)session.get(carsDB.class, returnDate);
			session.update(carlist);
			session.getTransaction();
			log.info("returnDate changed to : "+carlist.getReturnDate());
			return carlist;
        }catch(Exception e){e.printStackTrace();}
			
			finally{
				session.close();
			}
		return carlist;
	}
}
