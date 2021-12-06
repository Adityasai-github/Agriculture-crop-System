package com.example.traderservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dealer {
@Id
private String dealerid;
private String dealername;
private String dealerpassword;
private String dealeraccno;
private String dealeremail;
private List<String> subscribedcrop;
public Dealer(String dealerid, String dealername, String dealerpassword, String dealeraccno, String dealeremail,
		List<String> subscribedcrop) {
	super();
	this.dealerid = dealerid;
	this.dealername = dealername;
	this.dealerpassword = dealerpassword;
	this.dealeraccno = dealeraccno;
	this.dealeremail = dealeremail;
	this.subscribedcrop = subscribedcrop;
}
public String getDealerid() {
	return dealerid;
}
public void setDealerid(String dealerid) {
	this.dealerid = dealerid;
}
public String getDealername() {
	return dealername;
}
public void setDealername(String dealername) {
	this.dealername = dealername;
}
public String getDealerpassword() {
	return dealerpassword;
}
public void setDealerpassword(String dealerpassword) {
	this.dealerpassword = dealerpassword;
}
public String getDealeraccno() {
	return dealeraccno;
}
public void setDealeraccno(String dealeraccno) {
	this.dealeraccno = dealeraccno;
}
public String getDealeremail() {
	return dealeremail;
}
public void setDealeremail(String dealeremail) {
	this.dealeremail = dealeremail;
}
public List<String> getSubscribedcrop() {
	return subscribedcrop;
}
public void setSubscribedcrop(List<String> subscribedcrop) {
	this.subscribedcrop = subscribedcrop;
}




}
