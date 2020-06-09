package com.ecomindo.spring.company.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomindo.spring.company.dto.CompanyDetailDto;
import com.ecomindo.spring.company.dto.CompanyDto;
import com.ecomindo.spring.company.dto.NewCompanyDto;
import com.ecomindo.spring.company.dto.SaveCompanyDetailDto;
import com.ecomindo.spring.company.dto.UpdateCompanyDto;
import com.ecomindo.spring.company.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDto> create(@Valid @RequestBody NewCompanyDto companyDto){
		return ResponseEntity.ok().body(companyService.createCompany(companyDto));
	}
	
	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDto> update(@Valid @RequestParam(value="id", required=true) long id, @Valid @RequestParam(value="name", required=true)String name ){
		UpdateCompanyDto companyDto = new UpdateCompanyDto(id,name);
		return ResponseEntity.ok().body(companyService.updateCompanyById(companyDto));
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id){
		return ResponseEntity.ok().body(companyService.deleteCompanyById(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CompanyDto>> getCompanys(){
		return ResponseEntity.ok().body(companyService.getAllCompany());
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDto> getById(@PathVariable Long id){
		return ResponseEntity.ok().body(companyService.getCompanyById(id)
				.orElse(null));
	}
	
	@PostMapping(value="/detail/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDetailDto> setDetail(@Valid @RequestBody SaveCompanyDetailDto companyDetailDto){
		return ResponseEntity.ok().body(companyService.saveDetail(companyDetailDto));
	}
	
	@DeleteMapping(value="/detail/delete/{companyId}")
	public ResponseEntity<Boolean> deleteDetail(@Valid @PathVariable("companyId") long companyId){
		return ResponseEntity.ok().body(companyService.deleteCompanyDetail(companyId));
	}
	
	@GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDto> getByName(@PathVariable String name){
		return ResponseEntity.ok().body(companyService.getCompanyByName(name)
				.orElse(null));
	}
}
