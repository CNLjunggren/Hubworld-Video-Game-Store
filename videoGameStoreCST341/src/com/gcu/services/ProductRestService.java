package com.gcu.services;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.Product;

@RestController
@RequestMapping("productService")
public class ProductRestService {

	private ProductBusinessInterface prodService;
	
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		return prodService.get_all_products();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable @NotNull int id)
	{
		return prodService.get_product_by_id(id);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public boolean deleteProductById(@PathVariable @NotNull int id)
	{
		return prodService.delete_product(id);
	}
	
	@PostMapping(path="/add")
	public Product addProduct(@RequestBody Product product)
	{
		if(prodService.add_product_to_db(product))
		{
			return product;
		}
		else
		{
			return null;
		}
	}
	
	@RequestMapping(path="/modify", method = RequestMethod.PUT,  headers = "Accept=application/json")
	public boolean modifyProduct(@RequestBody Product product)
	{
		return prodService.update_product(product);
	}
	
	@Autowired
	public void setProductService(ProductBusinessInterface i) {
		this.prodService = i;
	}
}
