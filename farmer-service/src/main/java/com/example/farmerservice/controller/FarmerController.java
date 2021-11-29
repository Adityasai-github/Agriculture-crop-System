package com.example.farmerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmer")
public class FarmerController {

	@GetMapping("/message")
	public String test() {
		return "Hello i called the farmer microservice";
	}
}