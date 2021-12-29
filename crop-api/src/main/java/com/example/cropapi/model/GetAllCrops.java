package com.example.cropapi.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class GetAllCrops {
List<Crop> cropList=new ArrayList<Crop>();


public GetAllCrops() {
	super();
	// TODO Auto-generated constructor stub
}

public List<Crop> getCropList() {
	return cropList;
}

public void setCropList(List<Crop> cropList) {
	this.cropList = cropList;
}

public GetAllCrops(List<Crop> cropList) {
	super();
	this.cropList = cropList;
}

}
