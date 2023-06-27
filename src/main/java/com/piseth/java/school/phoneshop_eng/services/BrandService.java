package com.piseth.java.school.phoneshop_eng.services;

import com.piseth.java.school.phoneshop_eng.models.Brand;

public interface BrandService {
	Brand save(Brand model);
	
	Brand getById(Long id);
}
