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
		
		
		ProjectManager sampleManager2 = new ProjectManager();
		sampleManager2.setFirstName("Mary");
		sampleManager2.setLastName("Watson");
		managerRepo.saveAndFlush(sampleManager2);
		
		Project sampleProject2 = new Project();
		sampleProject2.setStartDate(new Date(System.currentTimeMillis() - 120*1000 * 60 * 60 * 24 * 2));
		sampleProject2.setDueDate(new Date(System.currentTimeMillis() - 45*1000 * 60 * 60 * 24));
		sampleProject2.setProjectManager(sampleManager2);
		projectRepo.saveAndFlush(sampleProject2);
		
		Project sampleProject3 = new Project();
		sampleProject3.setStartDate(new Date(System.currentTimeMillis() - 60*1000 * 60 * 60 * 24 * 2));
		sampleProject3.setDueDate(new Date(System.currentTimeMillis() - 12*1000 * 60 * 60 * 24));
		sampleProject3.setProjectManager(sampleManager2);
		projectRepo.saveAndFlush(sampleProject3);
		
		sampleManager2 = managerRepo.getOne((long) 2);
		
		sampleManager2.setProjects(new HashSet<Project>(Arrays.asList(sampleProject2,sampleProject3)));
		managerRepo.save(sampleManager2);
		
		ProjectManager sampleManager3 = new ProjectManager();
		sampleManager3.setFirstName("Mary");
		sampleManager3.setLastName("Watson");
		managerRepo.saveAndFlush(sampleManager3);
		
		Project sampleProject4 = new Project();
		sampleProject4.setStartDate(new Date(System.currentTimeMillis() - 10*1000 * 60 * 60 * 24 * 2));
		sampleProject4.setDueDate(new Date(System.currentTimeMillis() - 45*1000 * 60 * 60 * 24));
		sampleProject4.setProjectManager(sampleManager3);
		projectRepo.saveAndFlush(sampleProject4);
		
		Project sampleProject5 = new Project();
		sampleProject5.setStartDate(new Date(System.currentTimeMillis() - 2*1000 * 60 * 60 * 24 * 2));
		sampleProject5.setDueDate(new Date(System.currentTimeMillis() - 12*1000 * 60 * 60 * 24));
		sampleProject5.setProjectManager(sampleManager3);
		projectRepo.saveAndFlush(sampleProject5);
		
		Project sampleProject6 = new Project();
		sampleProject6.setStartDate(new Date(System.currentTimeMillis() - 35*1000 * 60 * 60 * 24 * 2));
		sampleProject6.setDueDate(new Date(System.currentTimeMillis() - 10*1000 * 60 * 60 * 24));
		sampleProject6.setProjectManager(sampleManager3);
		projectRepo.saveAndFlush(sampleProject6);
		
		sampleManager3 = managerRepo.getOne((long) 2);
		
		sampleManager3.setProjects(new HashSet<Project>(Arrays.asList(sampleProject4,sampleProject5,sampleProject6)));
		managerRepo.save(sampleManager2);
    }
	
		
	
}
