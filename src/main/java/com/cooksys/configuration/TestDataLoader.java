package com.cooksys.configuration;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cooksys.entity.Project;
import com.cooksys.entity.ProjectManager;
import com.cooksys.repository.ProjectManagerRepository;
import com.cooksys.repository.ProjectRepository;

@Component
public class TestDataLoader {

	
	private ProjectRepository projectRepo;
	private ProjectManagerRepository managerRepo;

	public TestDataLoader(ProjectRepository projectRepo, ProjectManagerRepository managerRepo) {
		this.projectRepo = projectRepo;
		this.managerRepo = managerRepo;
	}
	
	@EventListener
	@Transactional
    public void handleContextRefresh(ContextRefreshedEvent event) {
		
		ProjectManager sampleManager = new ProjectManager();
		sampleManager.setFirstName("John");
		sampleManager.setLastName("Smith");
		managerRepo.saveAndFlush(sampleManager);
		
		Project sampleProject = new Project();
		sampleProject.setStartDate(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 2));
		sampleProject.setDueDate(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24));
		sampleProject.setProjectManager(sampleManager);
		projectRepo.saveAndFlush(sampleProject);
		
		sampleManager = managerRepo.getOne((long) 1);
		
		sampleManager.setProjects(new HashSet<Project>(Arrays.asList(sampleProject)));
		managerRepo.save(sampleManager);
		
		
    }
	
		
	
}
