package com.in28minutes.rest.webservices.RESTfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
//this class's instance is going to be managed by spring
public class UserDaoService {
	// this class will interact with the static arraylist

	private static List<User> users = new ArrayList<>();

	// i want to count the id automaticallty

	private static int countUsers = 100;

	static {
		users.add(new User(++countUsers, "Arijit", LocalDate.now().minusYears(24)));
		users.add(new User(++countUsers, "Vivek", LocalDate.now().minusYears(25)));
		users.add(new User(++countUsers, "Bishal", LocalDate.now().minusYears(40)));
		users.add(new User(++countUsers, "Arijit", LocalDate.now().minusYears(24)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		for (User u : users) {
			if (u.getId().equals(id))
				return u;
		}
		return null;
	}

	public User save(User user) {
		user.setId(++countUsers);
		users.add(user);
		return user;
	}

	public void deleteById(int id) {
		for (User u : users) {
			if (u.getId().equals(id)) {
				users.remove(u);
			}
		}

	}
}
