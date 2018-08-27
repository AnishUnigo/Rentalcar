package org.anish.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credit_card")
public class CreditCard {
	
	@Id
	String cc_number;
	
	String month;
	
	int year;
	
	int cvv;
	@Column(name="receipt_number")
	String receiptNumber;
	
	String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public String getCc_number() {
		return cc_number;
	}
	public void setCc_number(String cc_number) {
		this.cc_number = cc_number;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
}
