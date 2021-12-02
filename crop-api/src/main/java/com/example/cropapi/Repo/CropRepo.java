package com.example.cropapi.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.cropapi.model.Crop;

public interface  CropRepo extends MongoRepository<Crop, String> {
	@Query("{'cropname' : ?0}") List<Crop> findCropByName(String cropname);
	  
	@Query("{'croptype' : ?0}") List<Crop> findCropByType(String croptype);

}
