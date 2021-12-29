package com.example.traderservice.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.traderservice.model.Dealer;
@Repository
public interface  DealerRepo extends MongoRepository<Dealer, String> {
	@Query("{'dealername' : ?0}") Dealer findDealerByName(String dealername);

	@Query("{'dealername' : ?0}")void setDealername(String name);

	//@Query("{'subscribedcrop' : ?0}") List<String> findDealerByCrop(String subscribedcrop);

	@Query("{'dealerid' : ?0}") Dealer findDealerById(String dealerid);

	
}
