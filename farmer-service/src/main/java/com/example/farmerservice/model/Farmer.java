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
public String getFname() {
	return farmername;
}
public void setFname(String fname) {
	this.farmername = fname;
}
public String getFpassword() {
	return farmerpassword;
}
public void setFpassword(String fpassword) {
	this.farmerpassword = fpassword;
}
public String getFaccno() {
	return farmeraccno;
}
public void setFaccno(String faccno) {
	this.farmeraccno = faccno;
}
public String getFemail() {
	return farmeremail;
}
public void setFemail(String femail) {
	this.farmeremail = femail;
}
public List<Integer> getAllRatings() {
	return allRatings;
}
public void setAllRatings(List<Integer> allRatings) {
	this.allRatings = allRatings;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}

public void setID(String iD) {
	this.ID=iD;
	
}


}
