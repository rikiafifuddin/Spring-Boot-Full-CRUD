package com.ecomindo.spring.company.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
	private Long id;
	private String name;
	private String client;
	private BigDecimal budget;
	private List<EmployeeDto> employees;
}
