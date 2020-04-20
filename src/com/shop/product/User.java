package com.shop.product;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "[A-Za-z0-9]{2,20}", message = "Please enter a username consisting of only letters and digits, between 2 and 20 characters long.")
    private String username;
	
	@Size(min=8, message = "Password shoudl be 8 characters")
    private String password;
	
	@Size(min = 1, max = 20, message = "Please enter a first name between 1 and 20 characters long.")
    private String firstName;
	
	@Size(min = 1, max = 20, message = "Please enter a last name between 1 and 20 characters long.")
    private String lastName;
	
	@ValidEmailAddress
    private String emailAddress;
	
    private PhoneNumber phoneNumber;
    
    @Past(message = "Your birth date must be in the past.")
    private Date birthDate;
    
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	 
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
