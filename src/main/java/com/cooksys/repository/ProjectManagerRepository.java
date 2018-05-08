package com.cooksys.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.dto.ProjectDto;
import com.cooksys.entity.Project;
import com.cooksys.entity.ProjectManager;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long>{


	//List<Project> findAllProjectById(Long projectManagerId) ;
	

}
