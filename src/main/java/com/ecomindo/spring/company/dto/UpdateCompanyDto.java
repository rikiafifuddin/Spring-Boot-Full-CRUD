package com.ecomindo.spring.company.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyDto {
	
	@NotNull
	private Long id;
	
	@NotBlank
	@Size(min=1)
	private String name;
}
