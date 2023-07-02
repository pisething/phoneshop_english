package com.piseth.java.school.phoneshop_eng.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshop_eng.dtos.BrandDTO;
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
		return brandRepository.findById(id)
			.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Brand not found with id=" + id));
	}

	@Override
	public Brand update(Long brandId, BrandDTO dto) {
		Brand brand = getById(brandId);
		brand.setName(dto.getName()); // if many fields to update, please use mapper
		brandRepository.save(brand);
		return brand;
	}

	@Override
	public void delete(Long brandId) {
		Brand brand = getById(brandId);
		//brandRepository.delete(brand);
		brand.setActive(false);
		brandRepository.save(brand);
	}

}
