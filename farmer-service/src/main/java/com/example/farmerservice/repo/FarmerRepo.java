package com.example.farmerservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.farmerservice.model.Farmer;
@Repository
public interface  FarmerRepo extends MongoRepository<Farmer, String> {
 
	@Query("{'fname' : ?0}") 
	Farmer findFarmerByName(String fname);

	@Query("{'ID' : ?0}") void deleteById(String ID);

	boolean existsById(String ID);

	
	

	
	
}
