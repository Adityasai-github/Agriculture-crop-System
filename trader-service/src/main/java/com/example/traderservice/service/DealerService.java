package com.example.traderservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
	 @Autowired
	  private AuthenticationManager authenticationManager;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Dealer foundeddealer= repo1.findDealerByName(username);
		if(foundeddealer ==null) return null;
		String dealername=foundeddealer.getDealername();
		String dealerpassword=foundeddealer.getDealerpassword();
		
		return new User(dealername, dealerpassword,new  ArrayList<>());
	}
	public ResponseEntity<String> authDealer(Dealer dealer) {
		  String fName = dealer.getDealername();
		  String Password = dealer.getDealerpassword();
		  try {
		  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(fName, Password));
		  } catch (Exception e) {
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "Login Failed" );
		  }
		  return ResponseEntity.ok("Successfull");
		  }


		  }
		  
		  

