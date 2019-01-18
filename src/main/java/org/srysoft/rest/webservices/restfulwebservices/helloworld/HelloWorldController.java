package org.srysoft.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	// @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		HelloWorldBean hw = new HelloWorldBean("Hello World");
		// throw new RuntimeException("Some Error happen! Please Contact to support
		// team.");
		return hw;
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldFromPathVariable(@PathVariable String name) {
		HelloWorldBean hw = new HelloWorldBean(String.format("Hello World, %s", name));
		// throw new RuntimeException("Some Error happen! Please Contact to support
		// team.");
		return hw;
	}
}
