package com.piseth.java.school.phoneshop_eng.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshop_eng.models.Brand;
import com.piseth.java.school.phoneshop_eng.repositories.BrandRepository;
import com.piseth.java.school.phoneshop_eng.services.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand save(Brand model) {
		return brandRepository.save(model);
	}

}
