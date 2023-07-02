package com.piseth.java.school.phoneshop_eng.services;

import com.piseth.java.school.phoneshop_eng.dtos.BrandDTO;
import com.piseth.java.school.phoneshop_eng.models.Brand;

public interface BrandService {
	Brand save(Brand model);
	
	Brand getById(Long id);
	// @TODO put , delete, list
	
	Brand update(Long brandId, BrandDTO dto);
	
	void delete(Long brandId);
	
}
