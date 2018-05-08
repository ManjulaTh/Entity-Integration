package com.cooksys.configuration;

import java.util.Date;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cooksys.entity.Project;
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
    public void handleContextRefresh(ContextRefreshedEvent event) {
       
		
		Project sampleProject = new Project();
		sampleProject.setStartDate(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 2));
		sampleProject.setDueDate(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24));
		projectRepo.save(sampleProject);
		
    }
	
}
