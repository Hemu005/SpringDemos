package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {

	//for user and admin
	//http://localhost:8080/greet
	@GetMapping("/greet")
	public String greet() {
		return "Have a great day";
	}
	
	//for user and admin
	
	@GetMapping("/user/books/show")
	public List<String> showBooks(){
		return Arrays.asList("Java","spring");
	}
	
	//for admin
	
	@GetMapping("/greet/books/in")
	public String addBook() {
		return "Have a great day";
	}
}
