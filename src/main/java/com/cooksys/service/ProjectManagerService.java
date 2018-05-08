package com.cooksys.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.dto.OverdueProjectsDto;
import com.cooksys.dto.ProjectManagerDto;
import com.cooksys.entity.Project;
import com.cooksys.entity.ProjectManager;
import com.cooksys.exception.ReferencedEntityNotFoundException;
import com.cooksys.mapper.ProjectManagerMapper;
import com.cooksys.mapper.ProjectMapper;
import com.cooksys.repository.ProjectManagerRepository;
import com.cooksys.repository.ProjectRepository;

@Service
public class ProjectManagerService {

	private ProjectManagerRepository repo;
	private ProjectRepository projectRepo;
	private ProjectManagerMapper managerMapper;
	private ProjectMapper projectMapper;

	public ProjectManagerService(ProjectManagerRepository repo, ProjectRepository projectRepo, ProjectManagerMapper managerMapper, ProjectMapper projectMapper) {
		this.repo = repo;
		this.projectRepo = projectRepo;
		this.managerMapper = managerMapper;
		this.projectMapper = projectMapper;
	}
	
	public List<ProjectManagerDto> getAll() {
		return repo.findAll().stream().map(managerMapper::toDto).collect(Collectors.toList());
	}

	public boolean has(Long id) {
		return repo.exists(id);
	}

	public ProjectManagerDto get(Long id) {
		mustExist(id);
		return managerMapper.toDto(repo.findOne(id));
	}

	public Long post(ProjectManagerDto projectManagerDto) {
		projectManagerDto.setId(null);
		return repo.save(managerMapper.toEntity(projectManagerDto)).getId();
	}

	public void put(Long id, ProjectManagerDto projectManagerDto) {
		mustExist(id);
		projectManagerDto.setId(id);
		repo.save(managerMapper.toEntity(projectManagerDto));
	}
	
	private void mustExist(Long id) {
		if(!has(id))
			throw new ReferencedEntityNotFoundException(ProjectManager.class, id);
	}

	public void delete(Long id) {
		mustExist(id);
		repo.delete(id);
	}

	public List<Project> getProjects(Long projectManagerId) {
		return projectRepo.findAllByProjectManagerId(projectManagerId);
		
	}

	public OverdueProjectsDto getNoOfOverdueProjects(Long projectManagerId) {
		return new OverdueProjectsDto(projectManagerId, (long) projectRepo.findByProjectManagerIdAndDueDateLessThan(projectManagerId, new Date()).size());
		
	}

	public List<OverdueProjectsDto> getAllOverdueProjectsByManagers() {
		return repo.findAll().stream().map(manager -> new OverdueProjectsDto(manager.getId(), (long) projectRepo.findByProjectManagerIdAndDueDateLessThan(manager.getId(), new Date()).size())).collect(Collectors.toList());
	}
	
	
}
