package com.ecomindo.spring.company.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewProjectDto {
	
	@NotBlank
	@Size(min=1)
	private String name;
	
	@NotBlank
	private String client;
	
	@NotNull
	private BigDecimal budget;
	
}
