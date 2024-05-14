package com.in28minutes.rest.webservices.RESTfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// expose a REST api - @RestController
//give an actual url (hello-world)-@RequestMapping

@RestController
public class HelloWorldController {

	//@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hw")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hwb")
	public HelloWorldBean helloWorldBean() {
		String message="Hello World";
		return new HelloWorldBean(message);
	}
	
	@GetMapping(path="/hwb/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		String message="Hello World";
		return new HelloWorldBean(message+ name);
	}
}

