package com.gcu.business;

import java.util.List;

import com.gcu.model.User;

/**
 * This is the interface that handles the business interface for the website's users. This interface includes a initiation
 * method, destroy method, and a test method for any other product business services.
 * 
 * @author Caleb Ljunggren, Isaiah Johnson
 * Course Number: CST-341
 * Last updated: 10/15/2018 at 8:35pm
 * 
 * This is our own work
 */
public interface UsersBusinessInterface {

	public void init();
	public void destroy();
	public List<User> findAllUsers();
	public User findById(int id);
	public User findByUsername(String username);
	public boolean update_user(User user);
	public boolean deleteUser(int id);
	public boolean createUser(User u);
	public boolean register_user(User user);
	public boolean login_user(User user);
}
