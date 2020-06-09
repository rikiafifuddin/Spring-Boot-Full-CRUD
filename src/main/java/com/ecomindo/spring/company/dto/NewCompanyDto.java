package com.ecomindo.spring.company.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewCompanyDto {
	
	@NotBlank
	@Size(min=1)
	private String name;
	
	private SaveCompanyDetailDto companyDetail;
	
	
}
