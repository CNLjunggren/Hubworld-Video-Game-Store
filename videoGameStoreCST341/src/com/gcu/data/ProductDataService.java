package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.Product;


public class ProductDataService implements ProductDataAccessInterface<Product> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * This method will find all users in the database and return them in a list
	 * @return List<Product> Returns the populated product list
	 */
	public List<Product> findAll() 
	{
		String sql = "SELECT * FROM VIDEOGAMESTORE.PRODUCTS";
		
		// Instantiate a new Product list
		List<Product> products = new ArrayList<Product>();
		
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				// For each result, create a new product with fields and add it to the list
				products.add(new Product(srs.getString("PRODUCT_NAME"), srs.getDouble("PRICE"),
						srs.getString("SELLER"), srs.getInt("CONDITION"), srs.getString("IMAGE_PATH"), srs.getInt("ID")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return products;
	}
		
		
	/**
	 * This method will find a product by their id
	 * @param id 	The id of the product being searched
	 * @return Product 	The product that was found by db, null if not found
	 */
	public Product findById(int id) {
		String sql = "SELECT * FROM VIDEOGAMESTORE.PRODUCTS WHERE ID=" +id;
		
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while(srs.next())
			{
				// For each result, create a new product with fields and add it to the list
				return new Product(srs.getString("PRODUCT_NAME"), srs.getDouble("PRICE"),
						srs.getString("SELLER"), srs.getInt("CONDITION"), srs.getString("IMAGE_PATH"), srs.getInt("ID"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}


	/**
	 * This method will add a product to the database
	 * @param product	The Product that will be added to the database
	 * @return boolean	Return true if passed, false if something went wrong
	 */
	public boolean create(Product product) {
		
		String sql = "INSERT INTO VIDEOGAMESTORE.PRODUCTS(PRODUCT_NAME, PRICE, SELLER, CONDITION, IMAGE_PATH) VALUES (?, ?, ?, ?, ?)";
		
		try {
			// Execute the update method on jdbcTemplate, if it returns 1 row, it was successful
			int rows = jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getSeller(), product.getCondition(), product.getImagePath());
			return rows == 1 ? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}

	/**
	 * This method will update the given product's information in the database
	 * @param product	The product with updated fields
	 * @return boolean	Returns true if passed, false if something went wrong
	 */
	public boolean update(Product product) {
		String sql = "UPDATE VIDEOGAMESTORE.PRODUCTS SET PRODUCT_NAME=?, PRICE=?, SELLER=?, CONDITION=?, IMAGE_PATH=? WHERE ID = ?";
		
		try {
			// Execute the update method on jdbcTemplate, if it returns 1 row, it was successful
			int rows = jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getSeller(), product.getCondition(), product.getImagePath(), product.getId());
			return rows == 1 ? true : false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}

	
	/**
	 * This method will delete the product from the database
	 * @param product	The product that will be deleted
	 * @return boolean	Returns true if passed, false if something went wrong
	 */
	public boolean delete(int id) {
		String sql= "DELETE FROM VIDEOGAMESTORE.PRODUCTS WHERE ID=?";
		
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
	
	
	/**
	 * Sets the dataSource to be used
	 * @param dataSource	The datasource being used
	 */
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

}
