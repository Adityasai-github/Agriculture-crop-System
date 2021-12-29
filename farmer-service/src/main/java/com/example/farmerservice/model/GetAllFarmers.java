package com.example.farmerservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GetAllFarmers {
	List<Farmer> farmerList=new ArrayList<Farmer>();

	public GetAllFarmers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Farmer> getFarmerList() {
		return farmerList;
	}

	public void setFarmerList(List<Farmer> farmerList) {
		this.farmerList = farmerList;
	}

	public GetAllFarmers(List<Farmer> farmerList) {
		super();
		this.farmerList = farmerList;
	}
	
	

}
