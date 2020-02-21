/**
 * This is the controller that handles the product listing page. Currently this page supports data validation of a product listing creation attempt, and will
 * redirect the user to the store page if they successfully create a product.
 * 
 * TODO:
 * - We need to ensure the Product page will only let registered and logged in users create a product listing, with acceptable fields 
 *   of information based on the Product model.
 * 
 * @author Isaiah Johnson, Caleb Ljunggren
 * Course Number: CST-341
 * Last updated: 10/15/2018 at 8:34pm
 * 
 * This is our own work
 */

package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.Product;
import com.gcu.model.User;

@Controller
@RequestMapping("/hubworld")
public class ProductController 
{
	ProductBusinessInterface productInterface;
		
	// Redirects to showProducts.jsp
	@RequestMapping(path="/showProducts")
	public ModelAndView showProductList()
	{
		return new ModelAndView("showProducts", "product", new Product());
	}
	
	// This method will retrieve a list of users and pass the model to the manageProducts.jsp page
	@RequestMapping(path = "/manageProducts")
	public ModelAndView manageProductList(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		List<Product> productList = new ArrayList<Product>();

		// Instantiate productList by retrieving products from database
		productList = productInterface.get_all_products();

		// Pass list to the showProducts view
		return new ModelAndView("manageProducts", "products", productList);
	}
	
	
	@Autowired
	public void setProductService(ProductBusinessInterface i)
	{
		this.productInterface = i;
	}
}