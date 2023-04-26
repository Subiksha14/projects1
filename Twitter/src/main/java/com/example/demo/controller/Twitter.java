package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Twitter {

	@GetMapping("/login")
	public String Login()
	{
		return "Login Successful..";
	}
}
