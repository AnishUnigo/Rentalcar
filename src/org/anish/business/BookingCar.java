package org.anish.business;

import java.util.Date;

import org.anish.controller.SelectCarServlet;
import org.anish.hibernate.dto.carsDB;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class BookingCar {
	static SessionFactory sessionFactcory = new Configuration().configure().buildSessionFactory();
	static Logger log= Logger.getLogger(BookingCar.class);
		public static carsDB insertCarDetails(String carName, String carType, String fuelType, int carPrice, Date pickupDate, Date returnDate){
			Session session = sessionFactcory.openSession();
			carsDB cars=new carsDB();
			try{
			log.info("entered in insertCarDetails ");
			cars.setCarName(carName);
			cars.setCartype(carType);
			cars.setCarFuelType(fuelType);
			cars.setCarPrice(carPrice);
			cars.setPickupDate(pickupDate);
			cars.setReturnDate(returnDate);
			session.beginTransaction();
			session.save(cars);
			session.getTransaction().commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return cars;
	}
		public static carsDB findCars(String carName, String cartype,String fueltype,String l){
			Session session = sessionFactcory.openSession();
			try
	        {
				
				session.beginTransaction();
				Criteria criteria = session.createCriteria(carsDB.class);
				criteria.add(Restrictions.eq("carName", carName));
				criteria.add(Restrictions.eq("cartype", cartype));
				criteria.add(Restrictions.eq("carFuelType", fueltype));
				System.out.println("carname : "+carName);
				System.out.println("cartype : "+cartype);
				System.out.println("fueltype : "+fueltype);
				carsDB carlist = (carsDB) criteria.uniqueResult();
				System.out.println("in searchCars class : "+criteria.uniqueResult());	
				if(carlist!=null){
					System.out.println(" result : " +true);
					return carlist;
				}else{
					return carlist;
				}
	        }
	        catch (Exception e)
	        {
	        	System.out.println("Exception occired");
	        	e.printStackTrace();
	            throw e;
	        }
	        finally
	        {
	        	session.close();
	        }
		
		}
		
}
