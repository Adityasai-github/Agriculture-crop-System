package com.example.Adminapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Adminapi.model.Dealer;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/adddealer")
	public void placeDealer(@RequestBody Dealer dealer) {
		restTemplate.postForEntity("http://trader-service/trader/dealers", dealer, Dealer.class);
	}
	
	@GetMapping("/viewalldealers")
	public String showAllDealers() {
		return restTemplate.getForObject("http://trader-service/trader/alldealers", String.class);
	}
	
	@GetMapping("/viewallfarmers")
    public String showAllFarmers() {
  	  return restTemplate.getForObject("http://farmer-service/farmer/allfarmers", String.class);
    }
	
	
	
}
