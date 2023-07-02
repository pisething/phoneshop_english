package com.piseth.java.school.phoneshop_eng.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.phoneshop_eng.dtos.BrandDTO;
import com.piseth.java.school.phoneshop_eng.dtos.BrandResponseDTO;
import com.piseth.java.school.phoneshop_eng.mappers.BrandMapper;
import com.piseth.java.school.phoneshop_eng.models.Brand;
import com.piseth.java.school.phoneshop_eng.services.BrandService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/brands")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody BrandDTO dto) {
		Brand brand = BrandMapper.toBrand(dto);
		brand = brandService.save(brand);
		return ResponseEntity.ok(BrandMapper.toBrandResponseDTO(brand));
	}
	
	@GetMapping("{myId}")
	public ResponseEntity<BrandResponseDTO> getOneById(@PathVariable("myId") Long id){
		Brand brand = brandService.getById(id);
		return ResponseEntity.ok(BrandMapper.toBrandResponseDTO(brand));
	}
	
	@PutMapping("{brandId}")
	public ResponseEntity<?> updateById(@PathVariable Long brandId, @RequestBody BrandDTO dto) {
		log.info("Update brand with id = {}", brandId);
		Brand brand = brandService.update(brandId, dto);
		return ResponseEntity.ok(BrandMapper.toBrandResponseDTO(brand));
	}
	
	@DeleteMapping("{brandId}")
	public ResponseEntity<?> deleteById(@PathVariable Long brandId){
		log.info("Delete brand with id = {}", brandId);
		brandService.delete(brandId);
		//return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.noContent().build();
	}
}
