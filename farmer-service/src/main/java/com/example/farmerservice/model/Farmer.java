package com.example.farmerservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Farmer {
@Id
private String ID;
private String farmername;
private String farmerpassword;
private String farmeraccno;
private String farmeremail;
private int rating;
private List<Integer> allRatings;


public Farmer(String ID, String farmername, String farmerpassword, String farmeraccno, String farmeremail,int rating,List<Integer>allRatings ) {
	super();
	this.ID=ID;
	this.farmername = farmername;
	this.farmerpassword = farmerpassword;
	this.farmeraccno = farmeraccno;
	this.farmeremail = farmeremail;
	this.allRatings=allRatings;
	this.rating=rating;
}

public Farmer() {
	super();
	// TODO Auto-generated constructor stub
}

public String getID() {
	return ID;
}

public void setID(String iD) {
	ID = iD;
}

public String getFarmername() {
	return farmername;
}

public void setFarmername(String farmername) {
	this.farmername = farmername;
}

public String getFarmerpassword() {
	return farmerpassword;
}

public void setFarmerpassword(String farmerpassword) {
	this.farmerpassword = farmerpassword;
}

public String getFarmeraccno() {
	return farmeraccno;
}

public void setFarmeraccno(String farmeraccno) {
	this.farmeraccno = farmeraccno;
}

public String getFarmeremail() {
	return farmeremail;
}

public void setFarmeremail(String farmeremail) {
	this.farmeremail = farmeremail;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
}

public List<Integer> getAllRatings() {
	return allRatings;
}

public void setAllRatings(List<Integer> allRatings) {
	this.allRatings = allRatings;
}

}