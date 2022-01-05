
  package com.example.farmerservice.service;
  
  import java.util.ArrayList; import
  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import
  org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.core.userdetails.UsernameNotFoundException;
  import org.springframework.stereotype.Service; import
  com.example.farmerservice.model.Farmer; import
  com.example.farmerservice.repo.FarmerRepo;
  
  @Service public class FarmerService implements UserDetailsService {
  
  @Autowired 
  
  FarmerRepo repo;
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException { Farmer foundedfarmer=
  repo.findFarmerByName(username); 
  if(foundedfarmer ==null) 
	  return null; 
  String farmername=foundedfarmer.getFarmername(); 
  String farmerpassword=foundedfarmer.getFarmerpassword(); 
  return new org.springframework.security.core.userdetails.User(farmername,farmerpassword,new
  ArrayList<>());
  
  }
  public ResponseEntity<String> authFarmer(Farmer farmer) {
  String fName = farmer.getFarmername();
  String Password = farmer.getFarmerpassword();
  try {
  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(fName, Password));
  } catch (Exception e) {
  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "Login Failed" );
  }
  return ResponseEntity.ok("Successfull");
  }


  }
  
  
 