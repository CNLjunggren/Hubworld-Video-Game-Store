package com.gcu.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * This is the Product model, which is used for handling all information of a product. This model has validation rules set for each variable and is set for data
 * validation.
 * 
 * @author Isaiah Johnson, Caleb Ljunggren
 * Course Number: CST-341
 * Last updated: 10/15/2018 at 8:44pm
 * 
 * This is our own work
 */
public class Product 
{
	@NotNull(message="Name cannot be null.")
	@Size(min=2, max=40, message="Product name must be between 2 and 40 characters.")
	private String name;
	
	@NotNull(message="Price cannot be null.")
	@Digits(integer=6, fraction=2, message="Price of the item cannot be over $999,999.99 and must be two or fewer decimal points.")
	@Min(value=0, message="Price of the item cannot be a negative value")
	private double price;
	
	@NotNull(message="Seller cannot be null.")
	@Size(min=2, max=50, message="Seller name must be between 2 and 50 characters.")
	private String seller;
	
	@NotNull(message="Condition cannot be null.")
	private int condition;
	
	private String imagePath;
	
	private int id;
		
	public Product(String name, double price, String seller, int condition, String imagePath)
	{
		this.name = name;
		this.price = price;
		this.seller = seller;
		this.condition = condition;
		this.imagePath = imagePath;
	}
	
	public Product(String name, double price, String seller, int condition, String imagePath, int id)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.seller = seller;
		this.condition = condition;
		this.imagePath = imagePath;
	}
	
	public Product()
	{
		this.name = "";
		this.price = 0;
		this.seller = "";
		this.condition = 0;
		this.imagePath= "";
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}