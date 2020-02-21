package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.User;


public class SecurityDataService implements SecurityDataAccessInterface<User> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * This method will find all users in the database
	 * @return List<User>	The list of users that were found
	 */
	public List<User> findAll() 
	{
		String sql = "SELECT * FROM VIDEOGAMESTORE.USERS";
		
		// Instantiate a new list of Users.
		List<User> userList = new ArrayList<User>();
		
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				// Add a new User to the list for every row that is returned
				userList.add(new User(srs.getString("USERNAME"), srs.getString("PASSWORD"), srs.getString("EMAIL"),
						srs.getString("FIRST_NAME"), srs.getString("LAST_NAME"), srs.getInt("GENDER"), srs.getInt("USER_PRIVILEGE"), srs.getInt("ID")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userList;
	}
		
		
	/**
	 * This method will find a user by their id
	 * @param id	The id of the user
	 * @return User	The user that is retrieved from the database
	 */
	public User findById(int id) {
		String sql = "SELECT * FROM VIDEOGAMESTORES.USERS WHERE ID=" +id;
	
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				// Add a new User to the list for every row that is returned
				return new User(srs.getString("USERNAME"), srs.getString("PASSWORD"), srs.getString("EMAIL"),
						srs.getString("FIRST_NAME"), srs.getString("LAST_NAME"), srs.getInt("GENDER"), srs.getInt("USER_PRIVILEGE"), srs.getInt("ID"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	
	// Method will call INSERT statement to add a User to the database
	public boolean create(User u) {
		
		String sql = "INSERT INTO VIDEOGAMESTORE.USERS(USERNAME, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, GENDER, USER_PRIVILEGE)"
				+ "VALUES (?, ?, ?, ?, ?, ?,?)";
		
		// Call jdcbTemplate's update() function, if rows returns 1, it was successful.
		try {
			int rows = jdbcTemplate.update(sql, u.getUsername(), u.getPassword(), u.getEmailAddress(),
					u.getFirstName(), u.getLastName(), u.getGender(), u.getUserPrivilege());
			return rows == 1 ? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}

	
	/**
	 * This method will update information of a user in the database
	 * 
	 */
	public boolean update(User u) {
		
		String sql="UPDATE VIDEOGAMESTORE.USERS SET USERNAME=?, PASSWORD=?, FIRST_NAME=?, LAST_NAME=?, EMAIL=?, GENDER=?,"
				+ " USER_PRIVILEGE=? WHERE ID=?";
		
		try {
			int rows = jdbcTemplate.update(sql, u.getUsername(), u.getPassword(), u.getFirstName(),
					u.getLastName(), u.getEmailAddress(), u.getGender(), u.getUserPrivilege(), u.getId());
			return rows == 1 ? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	

	// Delete user from database given user's id
	public boolean delete(int id) {
		String sql= "DELETE FROM VIDEOGAMESTORE.USERS WHERE ID=?";
		
		try {
			// Execute the update method on jdbcTemplate, if it returns 1 row, it was successful
			int rows = jdbcTemplate.update(sql, id);
			return rows == 1 ? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	// Method will return a User given a username
	public User findByUsername(String username)
	{
		String sql = "SELECT * FROM VIDEOGAMESTORE.USERS WHERE USERNAME=?";
		
		// Run a query with the supplied username
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, username);
			while(srs.next())
			{
				// Return a new User with the fields returned by the database
				return new User(srs.getString("USERNAME"), srs.getString("PASSWORD"), srs.getString("EMAIL"),
						srs.getString("FIRST_NAME"), srs.getString("LAST_NAME"), srs.getInt("GENDER"), srs.getInt("USER_PRIVILEGE"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Return an empty user if none are found
		return new User();
		
	}
	

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

}

