package com.example.Adminapi.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Farmer {
@Id
private String ID;
private int fid;
private String fname;
private String fpassword;
private String faccno;
private String femail;
private int rating;
private List<Integer> allRatings;


public Farmer(String ID,int fid, String fname, String fpassword, String faccno, String femail,int rating,List<Integer>allRatings ) {
	super();
	this.ID=ID;
	this.fid = fid;
	this.fname = fname;
	this.fpassword = fpassword;
	this.faccno = faccno;
	this.femail = femail;
	this.allRatings=allRatings;
	this.rating=rating;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getFpassword() {
	return fpassword;
}
public void setFpassword(String fpassword) {
	this.fpassword = fpassword;
}
public String getFaccno() {
	return faccno;
}
public void setFaccno(String faccno) {
	this.faccno = faccno;
}
public String getFemail() {
	return femail;
}
public void setFemail(String femail) {
	this.femail = femail;
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

}
