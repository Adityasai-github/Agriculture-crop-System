package com.example.cropapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cropapi.services.*;
import com.example.cropapi.model.Crop;
import com.example.cropapi.model.GetAllCrops;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

    @CrossOrigin(origins = "http://localhost:3000")
	@RestController
    @RequestMapping("/crops")
	public class CropController {
		@Autowired
		private CropService cropService;
		
		private static final String CropService = "Crop-Service";

		@CircuitBreaker(name=CropService,fallbackMethod = "cropFallback")
		
		 @GetMapping("/all")
		   public GetAllCrops showAllCrops(){
			   return cropService.showAllCrops();
		 }
		
		@PostMapping("/addcrops")
		public void placeCrop(@RequestBody Crop crop) {
			cropService.placeCrop(crop);
		}
		
		 
		 
		 @GetMapping("/crops/{cropname}")
		  public List<Crop> findCrop ( @PathVariable String cropname) {
			  return cropService.findCrop(cropname);
		  }
		 @GetMapping("/cropbyid/{cropid}")
		 public List<Crop> findCropId (@PathVariable  String cropid){
			return cropService.findCropId(cropid);
			 
		 }
		 
		 @GetMapping("/croptype/{croptype}")
		  public List<Crop> findCropType ( @PathVariable String croptype) {
			  return cropService.findCropType(croptype);
		  }
		 
		 
		 
		 @PutMapping("/updatecrop/{cropid}")
		  public String updateCrop(@RequestBody Crop crop, @PathVariable String cropid) {
		      cropService.updateCrop(crop, cropid);
		      return ("Updated Successfully");
		  }
		 
		 @PutMapping("/buycrop/{cropid}")
		    public void buyCrop(@RequestBody Crop crop,@PathVariable("cropid") String cropid) {
		        crop.setCropid( cropid );
		        
		        cropService.buyCrop(crop, cropid);
		      
		  
		    }
			@GetMapping("/deletecrop/{cropid}")
			public String deleteCrop( @PathVariable String cropid )	{
				cropService.deleteCrop( cropid );
				return ("Deleted Successfully");
			}
			 public ResponseEntity<String> cropFallback(Exception e){
				  return new ResponseEntity<String>("Crop service is very busy",HttpStatus.OK); 
				  
			  }


	}
