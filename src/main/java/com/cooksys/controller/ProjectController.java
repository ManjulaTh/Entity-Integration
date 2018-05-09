package com.cooksys.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.ProjectDto;
import com.cooksys.mapper.ProjectMapper;
import com.cooksys.service.ProjectService;

	
@RestController
@RequestMapping("project")
public class ProjectController {
	private ProjectMapper projectMapper;
	private ProjectService projectService;
		
	
	public ProjectController(ProjectMapper projectMapper, ProjectService projectService ) {
		super();
		this.projectMapper = projectMapper;
		this.projectService = projectService;
	}
	
	@PostMapping
	public void createProject(@RequestBody @Valid ProjectDto dto) {
		projectService.create(projectMapper.toEntity(dto));
	}
	
	@GetMapping
	public List<ProjectDto> findAll(@RequestParam(name="overdue", required =false) Boolean overdue){
		if(overdue != null) {
			return projectService.findOverdueProjects().stream().map(projectMapper::toDto).collect(Collectors.toList());
		}else {
			return projectService.findAll().stream().map(projectMapper::toDto).collect(Collectors.toList());
			
		}
	}
	
	
	
}
	
