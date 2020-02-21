package com.gcu.business;

import java.util.List;

import com.gcu.model.Product;

/**
 * This is the interface that handles the business interface for the website's products. This interface includes a initiation method,
 * destroy method, and a test method for any other product business services.
 * 
 * @author Isaiah Johnson, Caleb Ljunggren
 * Course Number: CST-341
 * Last updated: 10/15/2018 at 8:35pm
 * 
 * This is our own work
 */
public interface ProductBusinessInterface 
{
	public void init();
	public void destroy();
	public boolean add_product_to_db(Product p);
	public Product get_product_by_id(int id);
	public List<Product> get_all_products();
	public boolean update_product(Product p);
	public boolean delete_product(int id);
}