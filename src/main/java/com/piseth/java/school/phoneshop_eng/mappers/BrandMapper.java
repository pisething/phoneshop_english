package com.piseth.java.school.phoneshop_eng.mappers;

import com.piseth.java.school.phoneshop_eng.dtos.BrandDTO;
import com.piseth.java.school.phoneshop_eng.dtos.BrandResponseDTO;
import com.piseth.java.school.phoneshop_eng.models.Brand;

public class BrandMapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setActive(true);
		brand.setName(dto.getName());
		return brand;
	}
	
	public static BrandResponseDTO toBrandResponseDTO(Brand entity) {
		BrandResponseDTO dto = new BrandResponseDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}
}
