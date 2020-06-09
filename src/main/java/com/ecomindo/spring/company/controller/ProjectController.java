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
import org.springframework.web.bind.annotation.RestController;

import com.ecomindo.spring.company.dto.NewProjectDto;
import com.ecomindo.spring.company.dto.ProjectDto;
import com.ecomindo.spring.company.dto.UpdateProjectDto;
import com.ecomindo.spring.company.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<ProjectDto>> getAll(){
		return ResponseEntity.ok().body(projectService.getProjects());
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectDto> getById(@PathVariable long id){
		return ResponseEntity.ok().body(projectService.getProjectById(id)
				.orElse(null));
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody NewProjectDto projectDto){
		return ResponseEntity.ok().body(projectService.createProject(projectDto));
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<ProjectDto> updateProject(@Valid @RequestBody UpdateProjectDto projectDto){
		return ResponseEntity.ok().body(projectService.updateProject(projectDto));
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Boolean> deleteProject(@PathVariable long id){
		return ResponseEntity.ok().body(projectService.deleteProject(id));
	}
}
