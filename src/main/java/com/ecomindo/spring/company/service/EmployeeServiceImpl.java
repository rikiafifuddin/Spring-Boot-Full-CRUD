package com.ecomindo.spring.company.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomindo.spring.company.dto.CompanyDto;
import com.ecomindo.spring.company.dto.EmployeeDto;
import com.ecomindo.spring.company.dto.NewEmployeeDto;
import com.ecomindo.spring.company.dto.ProjectDto;
import com.ecomindo.spring.company.dto.UpdateEmployeeDto;
import com.ecomindo.spring.company.entity.Company;
import com.ecomindo.spring.company.entity.Employee;
import com.ecomindo.spring.company.entity.Project;
import com.ecomindo.spring.company.repository.CompanyRepository;
import com.ecomindo.spring.company.repository.EmployeeRepository;
import com.ecomindo.spring.company.repository.ProjectRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public EmployeeDto createEmployee(NewEmployeeDto employeeDto) {
		Company company = validateAndGetCompany(employeeDto.getCompanyId());
		Employee employee = new Employee(null
							, employeeDto.getName()
							, employeeDto.getSalary()
							, company
							, null);
		employee = employeeRepository.save(employee);
		return new EmployeeDto(employee.getId()
					, employee.getName()
					, employee.getSalary()
					, null
					, null);
	}
	
	@Override
	public List<EmployeeDto> getEmployees(){
		List<EmployeeDto> result = StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
				.map(e-> new EmployeeDto(e.getId()
						, e.getName()
						, e.getSalary()
						, new CompanyDto(e.getCompany().getId()
								,e.getCompany().getName()
								,null)
						, null))
				.collect(Collectors.toList());
		return result;
	}
	
	@Override
	public Optional<EmployeeDto> getEmployeeById(Long id){
		List<Long> ids = employeeRepository.findProjectId(id);
		List<ProjectDto> project = StreamSupport.stream(projectRepository.findAllById(ids).spliterator(), false)
				.map(x-> new ProjectDto(x.getId()
									, x.getName()
									, x.getClient()
									, x.getBudget()
									, null))
				.collect(Collectors.toList());
		
		return this.employeeRepository.findById(id)
				.map(e-> new EmployeeDto(e.getId()
						, e.getName()
						, e.getSalary()
						, new CompanyDto(e.getCompany().getId()
								, e.getCompany().getName()
								, null)
						,project));
	}
	
//	@Override
//	public List<EmployeeDto> getEmployeeByCompany(Long companyId){
//		return this.employeeRepository.findByCompany(companyId)
//				.stream()
//				.map(e-> new EmployeeDto(e.getId()
//							, e.getName()
//							, e.getSalary()
//							, null))
//				.collect(Collectors.toList());
//	}
	
	@Override
	public Boolean deleteEmployee(long employeeId) {
		if(!employeeRepository.existsById(employeeId))
			return false;
		
		employeeRepository.deleteById(employeeId);
		return true;
	}
	
	@Override
	public EmployeeDto updateEmployee(UpdateEmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(employeeDto.getId()).get();
		List<Project> projects = (List<Project>) projectRepository.findAllById(employeeDto.getProjectIds());
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setSalary(employeeDto.getSalary());
		employee.setProjects(projects);
		employee = employeeRepository.save(employee);
		
		return new EmployeeDto(employee.getId()
					, employee.getName()
					, employee.getSalary()
					, null
					, null);
	}
		
	private Company validateAndGetCompany(long companyId) {
		return companyRepository.findById(companyId)
				.orElseThrow(null);
	}
}
