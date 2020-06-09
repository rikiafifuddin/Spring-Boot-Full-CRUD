package com.ecomindo.spring.company.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomindo.spring.company.dto.EmployeeDto;
import com.ecomindo.spring.company.dto.NewEmployeeDto;
import com.ecomindo.spring.company.dto.UpdateEmployeeDto;
import com.ecomindo.spring.company.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value= "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDto> create(@Valid @RequestBody NewEmployeeDto employeeDto){
		return ResponseEntity.ok().body(employeeService.createEmployee(employeeDto));
	}
	
	@PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDto> update(@Valid @RequestBody UpdateEmployeeDto employeeDto){
		return ResponseEntity.ok().body(employeeService.updateEmployee(employeeDto));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDto>> getAll(){
		return ResponseEntity.ok().body(employeeService.getEmployees());
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<EmployeeDto>> getEmployeeById(@PathVariable Long id){
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}
	
//	@GetMapping(value="/company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<EmployeeDto>> getByCompany(@PathVariable Long companyId){
//		return ResponseEntity.ok().body(employeeService.getEmployeeByCompany(companyId));
//	}
	
	@DeleteMapping(value="/delete/{employeeId}")
	public ResponseEntity<Boolean> delete(@PathVariable long employeeId){
		return ResponseEntity.ok().body(employeeService.deleteEmployee(employeeId));
	}
	
}
