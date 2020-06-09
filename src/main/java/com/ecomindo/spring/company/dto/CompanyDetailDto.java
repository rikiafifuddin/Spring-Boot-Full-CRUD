package com.ecomindo.spring.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetailDto {
	
	private Long companyId;
	private String address;
	private String email;
	private String phone;
	private String postalCode;
	
	CompanyDto company;
}
