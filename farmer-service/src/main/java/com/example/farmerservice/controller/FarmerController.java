package com.example.farmerservice.controller;

import com.example.farmerservice.exception.ApiException;
import com.example.farmerservice.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.farmerservice.repo.FarmerRepo;
//import com.example.farmerservice.service.FarmerService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/farmer")
public class FarmerController {

	@Autowired
	FarmerRepo repo;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	GetAllFarmers getAllFarmers;
	/*
	 * @Autowired AuthenticationManager authenticationManager
	 */;
	/*
	 * @Autowired FarmerService farmerService;
	 */
	
	
	

	@PostMapping("/addfarmers")
	public void placefarmer(@RequestBody Farmer farmer) {
		repo.insert(farmer);
	}


	
	@PostMapping("/addcrop")
	public void placeCrop(@RequestBody Crop crop) {
		restTemplate.postForEntity("http://crop-api/crops/addcrops", crop, Crop.class);
	}

	
	@GetMapping("/allcrops")
	public String showAllCrops(){
 return   restTemplate.getForObject("http://crop-api/crops/all", String.class);

	}
	
	@GetMapping("/allmycrops/{cropid}")
	public String showFarmerCrops(@PathVariable("cropid") String cropid) {
		return restTemplate.getForObject("http://crop-api/crops/crop/" +cropid, String.class);
	}
	
	@GetMapping("/viewalldealers")
	public String showAllDealers() {
		return restTemplate.getForObject("http://trader-service/trader/alldealers", String.class);
	}
	 
	@GetMapping("/allfarmers")
	public GetAllFarmers showAllFarmers() {
		getAllFarmers.setFarmerList(repo.findAll());
		   return getAllFarmers;
    }
	
	       
	
	  @PutMapping("/rating/{ID}") 
	  public void giveRating(@RequestBody Farmer farmer, @PathVariable String ID)
	  { 
		  farmer.setID( ID );
		  Integer rating=farmer.getAllRatings().stream().mapToInt(Integer::intValue).sum()/farmer. getAllRatings().size(); farmer.setRating(rating); 
	  repo.save(farmer);
	  }
	 

	@GetMapping("/farmerbyid/{ID}")
	 public Farmer findfarmer ( @PathVariable String ID) {
		  return repo.findFarmerById(ID);
	  }
	@PutMapping("/updatefarmer/{ID}")
	 public String updateFarmerId(@RequestBody Farmer farmer, @PathVariable String ID) {
	      farmer.setID( ID );
	      repo.save(farmer);
	      return ("Updated farmer id  Successfully");
	  }
	 
	 @GetMapping("/deletefarmer/{ID}")
		 public void deleteFarmer(@PathVariable String ID) {
		    repo.deleteById(ID);
		     
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	/* public ResponseEntity<Object> deleteFarmer( @PathVariable String ID )	{
			boolean isFarmerExist = repo.existsById(ID);
			if (isFarmerExist) {
				farmerService.deleteById(ID);
			
			return new ResponseEntity<Object>("farmer deleted with id" + ID, HttpStatus.OK);
			} else {
				throw new ApiException("CAN NOT DELETE FARMER ,AS FARMER NOT FOUND WITH THIS ID ::");
			}
		}*/
	 
	 

}