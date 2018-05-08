package com.cooksys.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.dto.ProjectDto;
import com.cooksys.entity.Project;
import com.cooksys.entity.ProjectManager;
import com.cooksys.exception.ReferencedEntityNotFoundException;
import com.cooksys.mapper.ProjectMapper;
import com.cooksys.repository.ProjectRepository;


@Service
public class ProjectService {

	private ProjectRepository repo;
	private ProjectMapper mapper;

	public ProjectService(ProjectRepository repo, ProjectMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public void create(Project project) {
		repo.save(project);
	}
	public List<Project> findAll() {
		return repo.findAll();
	}

	public boolean has(Long id) {
		return repo.exists(id);
	}

	public ProjectDto get(Long id) {
		mustExist(id);
		return mapper.toDto(repo.findOne(id));
	}
	
	private void mustExist(Long id) {
		if(!has(id))
			throw new ReferencedEntityNotFoundException(Project.class, id);
	}

	public List<Project> findOverdueProjects() {
		// TODO Auto-generated method stub
		return repo.findByDueDateLessThan(new Date());
	}

	
}
