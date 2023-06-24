package com.piseth.java.school.phoneshop_eng.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.piseth.java.school.phoneshop_eng.dtos.BrandDTO;
import com.piseth.java.school.phoneshop_eng.mappers.BrandMapper;
import com.piseth.java.school.phoneshop_eng.models.Brand;
import com.piseth.java.school.phoneshop_eng.services.BrandService;

@RestController
@RequestMapping("/brands")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody BrandDTO dto) {
		Brand brand = BrandMapper.toBrand(dto);
		brand = brandService.save(brand);
		return ResponseEntity.ok(brand);
	}
}
