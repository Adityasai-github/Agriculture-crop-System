package com.example.traderservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Crop {
@Id

private String cropid;
private String cropname;
private String cropquantity;
private String cropaddress;
private String croptype;
private String cropmincost;

public Crop(String cropname, String cropid, String cropquantity, String cropaddress, String croptype,
		String cropmincost) {
	super();
	this.cropname = cropname;
	this.cropid = cropid;
	this.cropquantity = cropquantity;
	this.cropaddress = cropaddress;
	this.croptype = croptype;
	this.cropmincost = cropmincost;
}
public String getCropname() {
	return cropname;
}
public void setCropname(String cropname) {
	this.cropname = cropname;
}
public String getCropid() {
	return cropid;
}
public void setCropid(String cropid) {
	this.cropid = cropid;
}
public String getCropquantity() {
	return cropquantity;
}
public void setCropquantity(String cropquantity) {
	this.cropquantity = cropquantity;
}
public String getCropaddress() {
	return cropaddress;
}
public void setCropaddress(String cropaddress) {
	this.cropaddress = cropaddress;
}
public String getCroptype() {
	return croptype;
}
public void setCroptype(String croptype) {
	this.croptype = croptype;
}
public String getCropmincost() {
	return cropmincost;
}
public void setCropmincost(String cropmincost) {
	this.cropmincost = cropmincost;
}


}
