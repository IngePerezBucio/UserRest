package com.devs4j.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Steretopye
@RequestMapping("/hello")
public class Dev4jController {

	@GetMapping
	public String helloWorld () {
		return "Hello world";
	}
	
}
