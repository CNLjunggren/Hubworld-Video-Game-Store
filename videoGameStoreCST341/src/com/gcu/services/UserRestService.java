package com.gcu.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.UsersBusinessInterface;
import com.gcu.model.User;

@RestController
@RequestMapping("userService")
public class UserRestService {
	
	private UsersBusinessInterface userService;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.findAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable @NotNull int id)
	{
		return userService.findById(id);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public boolean deleteProductById(@PathVariable @NotNull int id)
	{
		return userService.deleteUser(id);
	}
	
	@PostMapping(path="/add")
	public boolean addProduct(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@RequestMapping(path="/modify", method = RequestMethod.PUT,  headers = "Accept=application/json")
	public boolean modifyProduct(@RequestBody User user)
	{
		return userService.update_user(user);
	}
	
	@Autowired
	public void setUserService(UsersBusinessInterface i) {
		this.userService = i;
	}
}
