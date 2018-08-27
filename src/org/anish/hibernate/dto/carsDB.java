package org.anish.hibernate.dto;
import java.io.Serializable;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.ws.BindingType;

@BindingType("http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
@WebService
@Entity
@Table(name="cars_db")
public class carsDB implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="car_id")
	private int carID;
	
	@Column(name="car_name")
	private String carName;
	
	@Column(name="car_type")
	private String cartype;
	
	@Column(name="fuel_type")
	private String carFuelType;
	
	@Column(name="car_price")
	private int carPrice;
	
	@Column(name="pickup_date")
	private Date pickupDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@Column(name="user_name")
	String username;
	
	@Column(name="receipt_number")
	String receiptnumber;
	
	public String getReceiptnumber() {
		return receiptnumber;
	}

	public void setReceiptnumber(String receiptnumber) {
		this.receiptnumber = receiptnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarFuelType() {
		return carFuelType;
	}

	public void setCarFuelType(String carFuelType) {
		this.carFuelType = carFuelType;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	

}
