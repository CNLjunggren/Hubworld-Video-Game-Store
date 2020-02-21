package com.gcu.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This is the User model, which is used for handling all information of the user. This will be used later on when we add other types
 * of data/variables users can enter elsewhere on the site. This model has validation rules set for each variable and is set for data
 * validation.
 * 
 * @author Caleb Ljunggren
 * Course Number: CST-341
 * Last updated: 9/24/2018 at 6:08pm
 * 
 * This is our own work
 */

public class User
{
	@NotNull(message="Username cannot be null.")
	@Size(min=5, max=30, message="*Username must be between 5 and 30 characters.")
	protected String username;
	
	@NotNull(message="Password cannot be null.")
	@Size(min=5, max=30, message="*Password must be between 5 and 30 characters.")
	protected String password;
	
	@NotNull(message="Email address cannot be null.")
	@Size(min=5, max=50, message="*Email address must be between 5 and 30 characters.")
	private String emailAddress;
	
	@NotNull(message="First name cannot be null.")
	@Size(min=2, max=30, message="*First name must be between 2 and 30 characters.")
	private String firstName;
	
	@NotNull(message="Last name cannot be null.")
	@Size(min=2, max=30, message="*Last name must be between 2 and 30 characters.")
	private String lastName;
	
	@NotNull(message="Gender cannot be null.")
	@Min(value=0, message="*Invalid value for gender.")
	@Max(value=1, message="*Invalid value for gender.")
	private int gender;
	
	private int userPrivilege;
	
	private int id;
	
	// Default Constructor
	public User()
	{
		username = "";
		password = "";
	}
	
	public User(String username, String password, String emailAddress, String firstName, String lastName, int gender, int userPrivilege)
	{
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.userPrivilege = userPrivilege;
	}
	
	public User(String username, String password, String emailAddress, String firstName, String lastName, int gender, int userPrivilege, int id)
	{
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.userPrivilege = userPrivilege;
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName ()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(int userPrivilege) {
		this.userPrivilege = userPrivilege;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}