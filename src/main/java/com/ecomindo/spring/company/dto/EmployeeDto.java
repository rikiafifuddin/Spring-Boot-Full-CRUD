package com.ecomindo.spring.company.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private Long id;
	private String name;
	private BigDecimal salary;
	
	//many to one
	private CompanyDto company;
	
	//manytomany
	private List<ProjectDto> projects;
}
