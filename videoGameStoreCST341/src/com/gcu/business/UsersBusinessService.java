package com.gcu.business;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.data.SecurityDataAccessInterface;
import com.gcu.model.User;

/**
 * This is the business service that handles the services for the website's users. This includes a initiation method,
 * destroy method, and a test method for any other user business services.
 * 
 * @author Caleb Ljunggren, Isaiah Johnson
 * Course Number: CST-341
 * Last updated: 10/15/2018 at 8:35pm
 * 
 * This is our own work
 */
public class UsersBusinessService implements UsersBusinessInterface 
{
	
	private SecurityDataAccessInterface<User> dao;
	
	
	public void init()
	{
		System.out.println("Initializing UsersBusinessService");
	}
	
	public void destroy()
	{
		System.out.println("Destroying UsersBusinessService");
	}
	
	// Retrieves a list of all users from the database
	public List<User> findAllUsers()
	{
		return dao.findAll();
	}
	
	public User findById(int id)
	{
		return dao.findById(id);
	}
	
	// Retrieves the password of the user by querying the database for the username
	public boolean login_user(User user) {
		// Store the password inputted by the user.
		String password = user.getPassword();
		
		// Repopulate the user object with info retrieved from the database.
		user = dao.findByUsername(user.getUsername());
		
		// Check to see that the stored password matches the password in the database, return result
		if(password.equals(user.getPassword()) && password!=null)
		{
			return true;
		}
		return false;
	}
	
	// Call dao's findByUsername to return a user object of username given
	public User findByUsername(String username)
	{
		return dao.findByUsername(username);
	}
	
	// Call dao's update function to modify existing user information
	public boolean update_user(User user)
	{
		return dao.update(user);
	}
	
	// Call dao's delete function to delete user from database
	public boolean deleteUser(int id)
	{
		return dao.delete(id);
	}
	
	public boolean createUser(User u) {
		return dao.create(u);
	}
	
	// Call dao's create function to add user to the database, return result
	public boolean register_user(User user) {
		return dao.create(user);
	}
	
	@Autowired
	public void setDataService(SecurityDataAccessInterface<User> i) {
		this.dao = i;
	}
}