package com.ecomindo.spring.company.service;

import java.util.List;
import java.util.Optional;

import com.ecomindo.spring.company.dto.EmployeeDto;
import com.ecomindo.spring.company.dto.NewEmployeeDto;
import com.ecomindo.spring.company.dto.UpdateEmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(NewEmployeeDto employeeDto);

	List<EmployeeDto> getEmployees();

	Optional<EmployeeDto> getEmployeeById(Long id);

//	List<EmployeeDto> getEmployeeByCompany(Long companyId);

	Boolean deleteEmployee(long employeeId);

	EmployeeDto updateEmployee(UpdateEmployeeDto employeeDto);

}
