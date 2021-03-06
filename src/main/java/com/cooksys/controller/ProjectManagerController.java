package com.cooksys.controller;

import java.util.List;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.OverdueProjectsDto;
import com.cooksys.dto.ProjectDto;
import com.cooksys.dto.ProjectManagerDto;
import com.cooksys.mapper.ProjectManagerMapper;
import com.cooksys.mapper.ProjectMapper;
import com.cooksys.service.ProjectManagerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("projectManager")
public class ProjectManagerController {

	private ProjectManagerService projectManagerService;
	private ProjectManagerMapper projectManagerMapper;
	private ProjectMapper projectMapper;

	public ProjectManagerController(ProjectManagerService projectManagerService,
			ProjectManagerMapper projectManagerMapper, ProjectMapper projectMapper) {
		this.projectManagerService = projectManagerService;
		this.projectManagerMapper = projectManagerMapper;
		this.projectMapper = projectMapper;
	}
	
	@GetMapping
	@ApiOperation(value = "", nickname = "getAllProjectManagers")
	public List<ProjectManagerDto> getAll() {
		return projectManagerService.getAll();
	}

	@RequestMapping(method = RequestMethod.HEAD, value = "{id}")
	@ApiOperation(value = "", nickname = "projectManagerExistsForId")
	public void has(@PathVariable Long id, HttpServletResponse httpResponse) {
		if(!projectManagerService.has(id))
			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	@GetMapping("{id}")
	@ApiOperation(value = "", nickname = "getProjectManagerById")
	public ProjectManagerDto get(@PathVariable Long id) {
		return projectManagerService.get(id);
	}
	
	@GetMapping("{id}/project")
	private List<ProjectDto> getProjects(@PathVariable("id") Long projectManagerId){
		return projectManagerService.getProjects(projectManagerId).stream().map(projectMapper::toDto).collect(Collectors.toList());
	}

	@GetMapping("{id}/overdue")
	public OverdueProjectsDto getNoOfProjects(@PathVariable("id") Long projectManagerId) {
		return projectManagerService.getNoOfOverdueProjects(projectManagerId);
	}
	
	@GetMapping("overdue")
	public List<OverdueProjectsDto> getAllOverdueProjectsByManagers(){ 
		return projectManagerService.getAllOverdueProjectsByManagers();
	}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postNewProjectManager")
	public Long post(@RequestBody @Valid @Validated ProjectManagerDto projectManagerDto, HttpServletResponse httpResponse) {
		Long id = projectManagerService.post(projectManagerDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return id;
	}
	
	@PutMapping("{id}")
	@ApiOperation(value = "", nickname = "putProjectManagerWithId")
	public void put(@PathVariable Long id, @RequestBody @Valid @Validated ProjectManagerDto projectManagerDto, HttpServletResponse httpResponse) {
		projectManagerService.put(id, projectManagerDto);
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "", nickname = "deleteProjectManagerAtId")
	public void delete(@PathVariable Long id, HttpServletResponse httpResponse) {
		projectManagerService.delete(id);
	}

}
