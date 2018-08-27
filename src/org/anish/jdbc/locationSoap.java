package org.anish.jdbc;

import javax.jws.WebService;

@WebService(name="Location",
portName="LocationPort",
serviceName="LocationService",
targetNamespace="http://localhost:4040/RentalCar")
public class locationSoap {
	public boolean Authenticate(String street, String city){
		boolean res=rentalCarDB.insertLocation(street, city);
		return res;
	} 
}
