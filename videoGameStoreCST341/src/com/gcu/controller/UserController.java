package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UsersBusinessInterface;
import com.gcu.model.Product;
import com.gcu.model.User;
import com.gcu.model.UserLogin;

@Controller
@RequestMapping("/hubworld")
/**
 * This is the controller that handles the user login page. Currently this page
 * supports data validation of a login attempt and will redirect the user to the
 * store page if they successfully log in.
 * 
 * TODO: - Once a database is set up, we need to ensure the Login page will only
 * let registered users login, with the correct username and password (May allow
 * the user to interchange their username and email address to login).
 * 
 * @author Caleb Ljunggren, Isaiah Johnson Course Number: CST-341 Last updated:
 *         10/15/2018 at 8:12pm * This is our own work
 */
public class UserController {
	UsersBusinessInterface busInterface;

	
	// This method returns the login.jsp view with a new User model
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		// Set the user session object to null if it was set to a user
		session.setAttribute("user", null);
		return new ModelAndView("loginUser", "user", new User());
	}

	
	// This method returns loginUser.jsp view with a User model submitted through login form
	@RequestMapping(path = "/loginuser", method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("user") UserLogin user, BindingResult result,
			HttpSession session) {

		// Check to see if the form submitted has any errors.
		if (result.hasErrors()) {
			return new ModelAndView("loginUser", "user", user);
		}

		// Call business service's login method, return the result (true if logged in succssfully)
		boolean loginResult = busInterface.login_user(user);

		// Redirect to the store page if user logged in correctly. Redirect will call the StoreController's index() method
		if (loginResult) {
			// Retrieve a user from the database by their username if they logged in succesfully
			User u = busInterface.findByUsername(user.getUsername());

			// Set a session attribute called user with the user retrieved from the database
			session.setAttribute("user", u);

			return new ModelAndView("redirect:/hubworld/store", "", null);
		}

		// If loginResult is false, return to the loginForm
		return new ModelAndView("loginUser", "user", user);
	}

	
	// Method that returns a view with a form for registering a User
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("registerUser", "user", new User("", "", "", "", "", 0, 0));
	}

	
	// Method that will register a user and add them to the database.
	@RequestMapping(path = "/registeruser", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		// Validate that there are no errors in the User model
		if (result.hasErrors()) {
			return new ModelAndView("registerUser", "user", user);
		}

		// Call register user function in the business service.
		busInterface.register_user(user);

		// Redirect the user to the store the login screen if they are registered successfully.
		return new ModelAndView("login", "", null);
	}

	// Redirects to showUsers.jsp
	@RequestMapping(path="/showUsers")
	public String showUserList()
	{
		return "showUsers";
	}
	
	// This method will retrieve a list of users and pass the model to the showProducts.jsp page
	@RequestMapping(path = "/manageUsers")
	public ModelAndView manageUserList(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpSession session) {
		List<User> userList = new ArrayList<User>();

		// Instantiate userList by retrieving products from database
		userList = busInterface.findAllUsers();

		// Pass list to the showUsers view
		return new ModelAndView("manageUsers", "users", userList);
	}

	
	// Method will take a parameter named 'modify' which is passed when modify
	// button is pressed on showUsers.jsp
	@RequestMapping(path = "/modifyOrDeleteUser", method = RequestMethod.POST, params = "modify")
	public ModelAndView modifyUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		// Send user to business service's update_user method, which passes it do database
		busInterface.update_user(user);
		return new ModelAndView("showUsers", "", null);
	}

	
	// Method will take a parameter named 'delete' which is passed when delete button is pressed on showUsers.jsp
	@RequestMapping(path = "/modifyOrDeleteUser", method = RequestMethod.POST, params = "delete")
	public ModelAndView deleteUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		// Send user to business service's delete_user method, which will delete them from the database
		busInterface.deleteUser(user.getId());
		return new ModelAndView("showUsers", "", null);
	}

	@Autowired
	public void setUsersService(UsersBusinessInterface i) {
		this.busInterface = i;
	}
}