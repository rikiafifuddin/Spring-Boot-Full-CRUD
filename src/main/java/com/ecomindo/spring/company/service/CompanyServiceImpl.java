package com.ecomindo.spring.company.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomindo.spring.company.dto.CompanyDetailDto;
import com.ecomindo.spring.company.dto.CompanyDto;
import com.ecomindo.spring.company.dto.NewCompanyDto;
import com.ecomindo.spring.company.dto.SaveCompanyDetailDto;
import com.ecomindo.spring.company.dto.UpdateCompanyDto;
import com.ecomindo.spring.company.entity.Company;
import com.ecomindo.spring.company.entity.CompanyDetail;
import com.ecomindo.spring.company.exception.CompanyExistsException;
import com.ecomindo.spring.company.exception.CompanyNotFoundException;
import com.ecomindo.spring.company.repository.CompanyRepository;


@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public CompanyDto createCompany(NewCompanyDto companyDto) {
		Optional<Company> findcompany = companyRepository.findByName(companyDto.getName());
		if (findcompany.isPresent()) 
			throw new CompanyExistsException(companyDto.getName());
		
		CompanyDetail companyDetail = null;
		Company company = new Company(null
							, companyDto.getName()
							, companyDetail
							, null);
		company = this.companyRepository.save(company);
		return new CompanyDto(company.getId()
						, company.getName()
						, null);
	}
	
	@Override
	public List<CompanyDto> getAllCompany(){
		return StreamSupport.stream(this.companyRepository.findAll().spliterator(), false)
				.map(e-> new CompanyDto(e.getId()
								, e.getName()
								, null))
				.collect(Collectors.toList());			
	}
	
	@Override
	public Optional<CompanyDto> getCompanyById(Long id){
		Optional<Company> findcompany = companyRepository.findById(id);
		if(!findcompany.isPresent()) 
			throw new CompanyNotFoundException(id);
		
		else if(companyRepository.findById(id).get().getCompanyDetail() == null) 
			return this.companyRepository.findById(id)
					.map(e-> new CompanyDto(e.getId()
										, e.getName()
										, null));
		
		else 
			return this.companyRepository.findById(id)
					.map(e-> new CompanyDto(e.getId()
										, e.getName()
										, new CompanyDetailDto(e.getCompanyDetail().getCompanyId()
												,e.getCompanyDetail().getAddress()
												,e.getCompanyDetail().getEmail()
												,e.getCompanyDetail().getPhone()
												,e.getCompanyDetail().getPostalCode()
												, null)));
	}
	
	@Override
	public Boolean deleteCompanyById(Long id) {
		if(!getCompanyById(id).isPresent())
			throw new CompanyNotFoundException(id);
			
		companyRepository.deleteById(id);
		return true;
		
	}
	
	@Override
	public CompanyDto updateCompanyById(UpdateCompanyDto companyDto) {
		Company company = new Company();
		company = companyRepository.findById(companyDto.getId()).get();
		company.setName(companyDto.getName());
		company = this.companyRepository.save(company);
		
		return new CompanyDto(company.getId()
				, company.getName()
				, null);
	}
	
	@Override
	public CompanyDetailDto saveDetail(SaveCompanyDetailDto companyDto) {
		
		Company company =companyRepository.findById(companyDto.getCompanyId()).get();
		
		CompanyDetail companyDetail = new CompanyDetail(company.getId()
										, companyDto.getAddress()
										, companyDto.getEmail()
										, companyDto.getPhone()
										, companyDto.getPostalCode()
										, null);
		company.setCompanyDetail(companyDetail);
		companyRepository.save(company);
				
		
		return new CompanyDetailDto(company.getId()
							, companyDto.getAddress()
							, companyDto.getEmail()
							, companyDto.getPhone()
							, companyDto.getPostalCode()
							, null);
	}
	
	@Override
	public Boolean deleteCompanyDetail(Long companyId) {
		Optional<Company> company = companyRepository.findById(companyId);
		if(!company.isPresent()) return false;
		
		company.get().setCompanyDetail(null);
		companyRepository.save(company.get());
		return true;
	}
	
	@Override
	public Optional<CompanyDto> getCompanyByName(String name) {
		return companyRepository.findByName(name)
			.map(e-> new CompanyDto(e.getId()
					, e.getName()
					, new CompanyDetailDto(e.getCompanyDetail().getCompanyId()
							,e.getCompanyDetail().getAddress()
							,e.getCompanyDetail().getEmail()
							,e.getCompanyDetail().getPhone()
							,e.getCompanyDetail().getPostalCode()
							, null )));
	}
	
	private Company findandGetCompanyByName(String name){
		return companyRepository.findByName(name)
				.orElseThrow(()-> new CompanyExistsException(name));
	}
	
}
