/**
 * This is the controller that handles the store page. Currently this page is only a placeholder for the actual store page, which will
 * be implemented later once a database has been created for and connected to the website.
 * 
 * @author Isaiah Johnson, Caleb Ljunggren
 * Course Number: CST-341
 * Last updated: 9/24/2018 at 5:58pm
 * 
 * This is our own work
 */

package com.gcu.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.Product;

@Controller
@RequestMapping("/hubworld")
public class StoreController
{
	ProductBusinessInterface productInterface;
	
	// Returns store.jsp view. Method will create a productList by querying the database.
	@RequestMapping(value = "/store", method=RequestMethod.GET)
	public ModelAndView index()
	{
		// Call productService's get_all_products() to create a list of all products
		List<Product> productList = productInterface.get_all_products();
		
		// Return the store view with the populated productList.
		return new ModelAndView("store", "products", productList);
	}
	
	
	@Autowired
	public void setProductService(ProductBusinessInterface i)
	{
		this.productInterface = i;
	}
}