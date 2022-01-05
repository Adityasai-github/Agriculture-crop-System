package com.example.traderservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GetAllDealers {
	List<Dealer> dealerList=new ArrayList<Dealer>();

	public GetAllDealers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAllDealers(List<Dealer> dealerList) {
		super();
		this.dealerList = dealerList;
	}

	public List<Dealer> getDealerList() {
		return dealerList;
	}

	public void setDealerList(List<Dealer> dealerList) {
		this.dealerList = dealerList;
	}
	

}
