package com.example.cropapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cropapi.Repo.CropRepo;
import com.example.cropapi.model.Crop;
import com.example.cropapi.model.GetAllCrops;

@Service
public class CropService {
	@Autowired
	CropRepo repos;
	@Autowired
	GetAllCrops getAllCrops;
	
	public void placeCrop(@RequestBody Crop crop) {
		repos.insert(crop);
	}
	 public GetAllCrops showAllCrops(){
		   getAllCrops.setCropList(repos.findAll());
		   return getAllCrops;
	 }
	 public List<Crop> findCrop ( @PathVariable String cropname) {
		  return repos.findCropByName(cropname);
	  }
	 public List<Crop> findCropId (@PathVariable  String cropid){
			return repos.CropById(cropid);
			 
		 }
	 public List<Crop> findCropType ( @PathVariable String croptype) {
		  return repos.findCropByType(croptype);
	  }
	 public String updateCrop(@RequestBody Crop crop, @PathVariable String id) {
	      crop.setCropid( id );
	      repos.save(crop);
	      return ("Updated Successfully");
	  }
	 public void buyCrop(@RequestBody Crop crop,@PathVariable("id") String id) {
	        crop.setCropid( id );
	        
	        repos.save(crop);
	 }
	 public String deleteCrop( @PathVariable String id )	{
			repos.deleteById( id );
			return ("Deleted Successfully");
		}
	 
}
