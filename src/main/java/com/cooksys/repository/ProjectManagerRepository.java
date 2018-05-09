package com.cooksys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.ProjectManager;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long>{

	Boolean existsByFirstNameAndLastName(String firstName, String lastName);


	//List<Project> findAllProjectById(Long projectManagerId) ;
	

}
