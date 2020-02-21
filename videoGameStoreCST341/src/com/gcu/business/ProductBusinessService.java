/**
 * This is the business service that handles the services for the website's products. This includes a initiation method,
 * destroy method, and a test method for any other product business services.
 * 
 * @author Isaiah Johnson, Caleb Ljunggren
 * Course Number: CST-341
 * Last updated: 10/15/2018 at 8:35pm
 * 
 * This is our own work
 */

package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.data.ProductDataAccessInterface;
import com.gcu.model.Product;


public class ProductBusinessService implements ProductBusinessInterface 
{
	
	private ProductDataAccessInterface<Product> dao;
	
	public void init()
	{
		System.out.println("Initializing ProductBusinessService");
	}
	
	public void destroy()
	{
		System.out.println("Destroying ProductBusinessService");
	}
	
	// Calls dao's create method, adding product to database and returning result
	public boolean add_product_to_db(Product p) {
		return dao.create(p);
	}	
	
	public Product get_product_by_id(int id)
	{
		return dao.findById(id);
	}
	
	// Calls dao's findAll() method, return a list of products
	public List<Product> get_all_products()
	{
		return dao.findAll();
	}
	
	public boolean update_product(Product p)
	{
		return dao.update(p);
	}
	
	public boolean delete_product(int id)
	{
		return dao.delete(id);
	}
	
	
	@Autowired
	public void setDataService(ProductDataAccessInterface<Product> i)
	{
		this.dao = i;
	}
}