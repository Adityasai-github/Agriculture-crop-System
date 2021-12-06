package com.example.farmerservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReturnAllCrops {

	List<Crop> listOfCrops = new ArrayList<Crop>();
	
	public ReturnAllCrops() {
		 
	}

	public ReturnAllCrops(List<Crop> listOfCrops) {
		super();
		this.listOfCrops = listOfCrops;
	}

	public List<Crop> getListOfCrops() {
		return this.listOfCrops;
	}

	public void setListOfCrops(List<Crop> listOfCrops) {
		this.listOfCrops = listOfCrops;
	}
 	
}