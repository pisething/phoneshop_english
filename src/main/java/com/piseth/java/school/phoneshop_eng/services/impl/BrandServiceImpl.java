package com.piseth.java.school.phoneshop_eng.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshop_eng.exception.ApiException;
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

	@Override
	public Brand getById(Long id) {
		/*
		Optional<Brand> optionalBrand = brandRepository.findById(id);
		if(optionalBrand.isPresent()) {
			return optionalBrand.get();
		}else {
			throw new ApiException(HttpStatus.NOT_FOUND, "Brand not found with id=" + id);
		}
		*/
		return brandRepository.findById(id)
			.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Brand not found with id=" + id));
	}

}
