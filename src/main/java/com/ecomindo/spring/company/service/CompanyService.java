package com.ecomindo.spring.company.service;

import java.util.List;
import java.util.Optional;

import com.ecomindo.spring.company.dto.CompanyDetailDto;
import com.ecomindo.spring.company.dto.CompanyDto;
import com.ecomindo.spring.company.dto.NewCompanyDto;
import com.ecomindo.spring.company.dto.SaveCompanyDetailDto;
import com.ecomindo.spring.company.dto.UpdateCompanyDto;

public interface CompanyService {

	CompanyDto createCompany(NewCompanyDto companyDto);
	List<CompanyDto> getAllCompany();
	Optional<CompanyDto> getCompanyById(Long id);
	Boolean deleteCompanyById(Long id);
	CompanyDto updateCompanyById(UpdateCompanyDto companyDto);
	CompanyDetailDto saveDetail(SaveCompanyDetailDto companyDto);
	Boolean deleteCompanyDetail(Long companyId);
	Optional<CompanyDto> getCompanyByName(String name);

}
