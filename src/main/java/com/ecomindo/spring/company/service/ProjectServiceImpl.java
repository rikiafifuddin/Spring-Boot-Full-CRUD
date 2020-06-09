package com.ecomindo.spring.company.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomindo.spring.company.dto.EmployeeDto;
import com.ecomindo.spring.company.dto.NewProjectDto;
import com.ecomindo.spring.company.dto.ProjectDto;
import com.ecomindo.spring.company.dto.UpdateProjectDto;
import com.ecomindo.spring.company.entity.Project;
import com.ecomindo.spring.company.repository.EmployeeRepository;
import com.ecomindo.spring.company.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public ProjectDto createProject(NewProjectDto projectDto) {
		
		Project project = new Project(null
						, projectDto.getName()
						, projectDto.getClient()
						, projectDto.getBudget()
						, null);
		project = this.projectRepository.save(project);
		
		return new ProjectDto(project.getId()
						, project.getName()
						, project.getClient()
						, project.getBudget()
						, null);
	}
	
	@Override
	public ProjectDto updateProject(UpdateProjectDto projectDto) {
		Project project = projectRepository.findById(projectDto.getId()).get();
		project.setName(projectDto.getName());
		project.setClient(projectDto.getClient());
		project.setBudget(projectDto.getBudget());
		project = projectRepository.save(project);
		
		return new ProjectDto(project.getId()
					, project.getName()
					, project.getClient()
					, project.getBudget()
					, null);
	}
	
	@Override
	public Boolean deleteProject(long projectId) {
		projectRepository.deleteById(projectId);
		return true;
	}
	
	@Override
	public List<ProjectDto> getProjects(){
		return StreamSupport.stream(projectRepository.findAll().spliterator(), false)
				.map(e-> new ProjectDto(e.getId()
							, e.getName()
							, e.getClient()
							, e.getBudget()
							, null))
				.collect(Collectors.toList());
	}
	
	@Override
	public Optional<ProjectDto> getProjectById(long projectId){
		List<Long> ids = projectRepository.findEmployeeId(projectId);
		List<EmployeeDto> employee = StreamSupport.stream(employeeRepository.findAllById(ids).spliterator(), false)
				.map(x-> new EmployeeDto(x.getId()
							, x.getName()
							, x.getSalary()
							, null
							, null))
				.collect(Collectors.toList());
				
		return projectRepository.findById(projectId)
				.map(e-> new ProjectDto(e.getId()
							, e.getName()
							, e.getClient()
							, e.getBudget()
							, employee));
	}
}
