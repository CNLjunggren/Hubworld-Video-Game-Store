package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.controller.UserController;
import com.gcu.services.ProductRestService;
import com.gcu.controller.ProductController;
import com.gcu.business.ProductBusinessService;
import com.gcu.business.UsersBusinessService;


@Configuration
/**
 * This is the new application configuration java file, which is used for handling all direction of the controllers between webpages.
 * 
 * @author Isaiah Johnson, Caleb Ljunggren
 * Course Number: CST-341
 * Last updated: 10/15/2018 at 8:46pm
 * 
 * This is our own work
 */
public class ApplicationConfiguration {
	
	@Bean(name="userController")
	public UserController getUserController()
	{
		return new UserController();
	}
	
	@Bean(name="productController")
	public ProductController getProductController()
	{
		return new ProductController();
	}
	
	
	@Bean(name="usersService", initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS) 
	public UsersBusinessService getUsersService()
	{
		return new UsersBusinessService();
	}
	
	@Bean(name="productService", initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS) 
	public ProductBusinessService getProductService()
	{
		return new ProductBusinessService();
	}

}
