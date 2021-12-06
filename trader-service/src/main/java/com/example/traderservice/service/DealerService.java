package com.example.traderservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.traderservice.model.Dealer;
import com.example.traderservice.repo.DealerRepo;
@Service
public class DealerService implements UserDetailsService {

	@Autowired
	DealerRepo repo1;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Dealer foundeddealer= repo1.findDealerByName(username);
		if(foundeddealer ==null) return null;
		String dealername=foundeddealer.getDealername();
		String dealerpassword=foundeddealer.getDealerpassword();
		return new User(dealername, dealerpassword,new  ArrayList<>());
	}

}
