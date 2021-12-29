package com.example.cropapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.cropapi.Repo.CropRepo;
import com.example.cropapi.model.Crop;
import com.example.cropapi.model.GetAllCrops;
import com.example.cropapi.services.CropService;

public class CropServiceTest {

	private CropRepo repos;
	private GetAllCrops getAllCrops;
	private CropService cropService;
	@BeforeEach
	void setUp() {
		repos=mock(CropRepo.class);
		cropService=new CropService(repos, getAllCrops);
	}
	
	@Test
	void placeCrop() {
		Crop crop= new Crop();
		crop.setCropmincost("");
		crop.setCropquantity("");
		
		assertThrows(NullPointerException.class, () ->cropService.placeCrop(crop));
		
		
	}
	
	
}
