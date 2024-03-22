package com.greetapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

//	http://localhost:8080/show
	@GetMapping("/show")
	public String showMessage() {
		return "Great Day";
	}
//	http://localhost:8080/say-hello/Hemu
//	data comes in the url itself
	@GetMapping("say-hello/{uname}")
	public String sayHello(@PathVariable("uname") String username) {
		return "Hello "+username;
	}
	
//	http://localhost:8080/user-details?uname=Hemu&&city=Mandya
//	data comes from the form
	@GetMapping("/user-details")
	public String showUserDetails(@RequestParam("uname") String username,
			                      @RequestParam("city") String city) {
		return "Welcome "+username+" from "+city;
	}
	
//  http://localhost:8080/
	@GetMapping("/show-courses")
	public List<String> showCourses(){
		return Arrays.asList("Java","Spring","Angular");
	}
}
