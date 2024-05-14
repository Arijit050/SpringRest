package com.in28minutes.rest.webservices.RESTfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	// to retrieve all user(GET)

	private UserDaoService service;

	@Autowired
	protected UserResource(UserDaoService userDaoService) {
		super();
		this.service = userDaoService;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		// i want to get the details from DAO service
		// so will have to use instance of the DAO class
		// to use it's methods.
		// so will use @Autowired

		return service.findAll();

	}

	@GetMapping("/user/{id}")
	public User retrieveyOneUser(@PathVariable Integer id) {

		return service.findOne(id);
	}

	// creating a user
	@PostMapping("/user")
	public void createUser(@RequestBody User user) {
		service.save(user);

	}
	//deleting a user by his id
	@DeleteMapping("/userDelete/{id}")
	public void DeleteOneUser(@PathVariable int id) {

		 service.deleteById(id);
	}

}
