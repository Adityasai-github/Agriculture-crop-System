package com.example.traderservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.example.traderservice.model.*;
import com.example.traderservice.repo.DealerRepo;



@RestController
@RequestMapping("/trader")
public class DealerController {
@Autowired
DealerRepo repo1;
@Autowired
RestTemplate restTemplate;

@Autowired
GetAllCrops getAllCrops;


 
    @PostMapping("/adddealers")
    public void placedealer(@RequestBody Dealer dealer) {
		repo1.insert(dealer);
	}
    

      @GetMapping("/alldealers")
      public List<Dealer> showAllDealers(){
		   return repo1.findAll();
		   }
      
      @GetMapping("/dealer/{dealerid}")
      public Dealer findDealerById ( @PathVariable String dealerid) {
    	  return repo1.findDealerById(dealerid);
      }
      @PutMapping("/giverating/{ID}")
      public String giveRatings(@RequestBody Farmer farmer, @PathVariable String ID) {
  	 
  	restTemplate.put("http://farmer-service/farmer/rating/"+ID, farmer);
  	return "rated successfully";
      }
      
      
      @GetMapping("/viewallcrops")
      public String showAllCrops(){
    	  return restTemplate.getForObject("http://crop-api/crops/all", String.class);
    	  
      }
      
      @GetMapping("/viewallfarmers")
      public String showAllFarmers() {
    	  return restTemplate.getForObject("http://farmer-service/farmer/allfarmers", String.class);
      }
      
      @GetMapping("/subscribedcrop/{dealerid}")
      public List<Crop> showSubscribedCrops(@PathVariable String dealerid){
    	  Dealer dealer= repo1.findDealerById(dealerid);
    	  GetAllCrops allCrops= restTemplate.getForObject("http://crop-api/crops/all", GetAllCrops.class );
    	  List<Crop> cropList=new ArrayList<Crop>();
    	  for (String dealername : dealer.getSubscribedcrop()) {
  			cropList.addAll(allCrops.getCropList().stream().filter(l -> l.getCropname().equalsIgnoreCase(dealername)).toList());	
  		}
  		return  cropList;
      }
      
 
      @PutMapping("/update/{dealername}")
     public String updatedealername(@RequestBody Dealer dealer, @PathVariable String dealername) {
 	      dealer.setDealername(dealername);
 	      repo1.save(dealer);
 	      return ("Updated dealer name  Successfully");
 	  }
      
      @PutMapping("/buycrop/{,cropid}")
      public String buycrop(@RequestBody Crop crop, @PathVariable String cropid) {
  	 
  	restTemplate.put("http://crop-api/crops/buycrop/"+cropid, crop);
  	 
  	return "requested the respective crop by id  successfully";
      }
      
      
      @DeleteMapping("/delete/{dealername}")
 	 public String deleteDealer( @PathVariable String id )	{
 			repo1.deleteById( id );
 			return ("Deleted the dealer by id Successfully");
 		}


}
