package com.ecomindo.spring.company.dto;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewEmployeeDto {
	@NotNull
	private Long companyId;
	
	@NotBlank
	private String name;
	
	@NotNull
	private BigDecimal salary;
	
	private List<Long> projectIds;
}
