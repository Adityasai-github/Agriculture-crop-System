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
	
	
	public CropService(CropRepo repos, GetAllCrops getAllCrops2) {
		// TODO Auto-generated constructor stub
	}
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
	 public void updateCrop(Crop crop,  String cropid) {
	      crop.setCropid( cropid );
	      repos.save(crop);

	  }
	 public void buyCrop(@RequestBody Crop crop,@PathVariable("cropid") String cropid) {
	        crop.setCropid( cropid );
	        
	        repos.save(crop);
	 }
	 public String deleteCrop( @PathVariable String cropid )	{
			repos.deleteById( cropid );
			return ("Deleted Successfully");
		}
	 
}
