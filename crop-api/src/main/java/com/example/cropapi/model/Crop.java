package com.example.cropapi.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

@Document
public class Crop {
@Id
private String cropid;
private String cropname;
private String cropquantity;
private String cropaddress;
private Binary cropImg;
private String croptype;
private String cropmincost;




public Crop(String cropname, String cropid, String cropquantity, String cropaddress, String croptype,Binary cropImg,
		String cropmincost) {
	super();
	this.cropname = cropname;
	this.cropid = cropid;
	this.cropquantity = cropquantity;
	this.cropaddress = cropaddress;
	this.croptype = croptype;
	this.cropmincost = cropmincost;
	this.cropImg=cropImg;
}
public Crop() {
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
public Binary getCropImg() {
	return cropImg;
}
public void setCropImg(Binary cropImg) {
	this.cropImg = cropImg;
}


}
