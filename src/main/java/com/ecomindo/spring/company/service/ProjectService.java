package com.ecomindo.spring.company.service;

import java.util.List;
import java.util.Optional;

import com.ecomindo.spring.company.dto.NewProjectDto;
import com.ecomindo.spring.company.dto.ProjectDto;
import com.ecomindo.spring.company.dto.UpdateProjectDto;

public interface ProjectService {

	ProjectDto createProject(NewProjectDto projectDto);

	ProjectDto updateProject(UpdateProjectDto projectDto);

	Boolean deleteProject(long projectId);

	List<ProjectDto> getProjects();

	Optional<ProjectDto> getProjectById(long projectId);

}
