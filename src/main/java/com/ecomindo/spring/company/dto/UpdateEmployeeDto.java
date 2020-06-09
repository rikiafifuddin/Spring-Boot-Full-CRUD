package com.ecomindo.spring.company.dto;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeDto {
	
	@NotNull
	@Min(value = 1)
	private Long id;
	
	@NotNull
	@Min(value = 1)
	private Long companyId;
	
	@NotBlank
	private String name;
	
	@NotNull
	private BigDecimal salary;
	
	private List<Long> projectIds;
}
