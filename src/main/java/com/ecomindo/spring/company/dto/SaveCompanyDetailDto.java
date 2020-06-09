package com.ecomindo.spring.company.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveCompanyDetailDto {
	
	@NotNull
	private Long companyId;
	
	@NotBlank
	@Size(min=1)
	private String address;
	
	@NotBlank(message= "please provide email")
	@Email
	private String email;
	
	@NotBlank
	@Size(min=1)
	private String phone;
	
	@NotBlank
	private String postalCode;
}
