package com.example.farmerservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.farmerservice.model.Farmer;
import com.example.farmerservice.repo.FarmerRepo;
@Service
public class FarmerService implements UserDetailsService {
	@Autowired
	FarmerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Farmer foundedfarmer= repo.findFarmerByName(username);
		if(foundedfarmer ==null) return null;
		String fname=foundedfarmer.getFname();
		String fpassword=foundedfarmer.getFpassword();
		return new org.springframework.security.core.userdetails.User(fname,fpassword,new ArrayList<>());
	}
}
