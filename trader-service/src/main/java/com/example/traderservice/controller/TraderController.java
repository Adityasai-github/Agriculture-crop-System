package com.example.traderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trader")
public class TraderController {

	@GetMapping("/message")
	public String test() {
		return "Hello i called the trader microservice";
	}
}