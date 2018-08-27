package org.anish.business;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

import org.anish.hibernate.dto.carsDB;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
@BindingType("http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
@WebService(name="searchCars",
portName="searchCarPort",
serviceName="searchCarService")
public class searchCars {
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	@WebMethod(action="find_cars", operationName="findcars")
	public boolean findcars(String carname, String cartype, String fueltype){
		
		carsDB cars= new carsDB();
		boolean result=false;
		
		Session session = sf.openSession();
		try
        {
			
			session.beginTransaction();
			Criteria criteria = session.createCriteria(carsDB.class);
			criteria.add(Restrictions.eq("carName", carname));
			criteria.add(Restrictions.eq("cartype", cartype));
			criteria.add(Restrictions.eq("carFuelType", fueltype));
			System.out.println("carname : "+carname);
			System.out.println("cartype : "+cartype);
			System.out.println("fueltype : "+fueltype);
			carsDB carlist = (carsDB) criteria.uniqueResult();
			System.out.println("in searchCars class : "+criteria.uniqueResult());	
			if(carlist!=null){
				System.out.println(" result : " +true);
				return true;
			}else{
				return false;
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
	@WebMethod(action="inser_cardetails", operationName="insertcardetials")
	public boolean insertcardetials(String carname,String cartype,String fueltype){
		
		 Session session = sf.openSession();
	      Transaction tx = null;
	     
	      boolean result=false;
	      try{
	         tx = session.beginTransaction();
	         carsDB carlist= new carsDB();
	         carlist.setCarName(carname);
	         carlist.setCartype(cartype);
	         carlist.setCarFuelType(fueltype);
	         session.save(carlist);
	         tx.commit();
	         result=true;
	         return result;
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return result;
	}
	
}
