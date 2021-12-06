package com.example.cropapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cropapi.Repo.CropRepo;

import com.example.cropapi.model.Crop;
import com.example.cropapi.model.GetAllCrops;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

	@RestController
    @RequestMapping("/crops")
	public class CropController {


		//private static final String CropService = Crop-Service;
		@Autowired
		CropRepo repos;
		@Autowired
		GetAllCrops getAllCrops;
		
		//@CircuitBreaker(name=CropService,fallbackMethod = "cropFallback")
		
		
		@PostMapping("/addcrops")
		public void placeCrop(@RequestBody Crop crop) {
			repos.insert(crop);
		}
		 @GetMapping("/all")
		   public GetAllCrops showAllCrops(){
			   getAllCrops.setCropList(repos.findAll());
			   return getAllCrops;
			   }
		 @GetMapping("/crops/{cropname}")
		  public List<Crop> findCrop ( @PathVariable String cropname) {
			  return repos.findCropByName(cropname);
		  }
		 @GetMapping("/crop/{cropid}")
		 public List<Crop> findCropId (@PathVariable  String cropid){
			return repos.CropById(cropid);
			 
		 }
		 
		 @GetMapping("/croptype/{croptype}")
		  public List<Crop> findCropType ( @PathVariable String croptype) {
			  return repos.findCropByType(croptype);
		  }
		 
		 
		 
		 @PutMapping("/updatecrop/{id}")
		  public String updateCrop(@RequestBody Crop crop, @PathVariable String id) {
		      crop.setCropid( id );
		      repos.save(crop);
		      return ("Updated Successfully");
		  }
		 
		 @PutMapping("/buycrop/{id}")
		    public void buyCrop(@RequestBody Crop crop,@PathVariable("id") String id) {
		        crop.setCropid( id );
		        
		        repos.save(crop);
		      
		  
		    }
			@DeleteMapping("/deletecrop/{id}")
			public String deleteCrop( @PathVariable String id )	{
				repos.deleteById( id );
				return ("Deleted Successfully");
			}
			/*
			 * public ResponseEntity<String> cropFallback(Exception e){ return new
			 * ResponseEntity<String>("Crop service is very busy",HttpStatus.OK); }
			 */
	}
