package com.cooksys.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cooksys.entity.Project;

public interface ProjectRepository extends JpaRepository <Project, Long>{
	
	List<Project> findAllByProjectManagerId(Long ProjectManagerId);

	List<Project> findByDueDateLessThan(Date date);

	List<Project> findByProjectManagerIdAndDueDateLessThan(Long projectManagerId, Date date);

}
