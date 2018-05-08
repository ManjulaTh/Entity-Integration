package com.cooksys.dto;

import java.util.Date;

import com.cooksys.dto.datatype.Reference;
import com.cooksys.entity.ProjectManager;


public class ProjectDto {
	private Long id;
	private Date startDate;
	private Date dueDate;
	private Reference<ProjectManager, Long> projectManager;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Reference<ProjectManager, Long> getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(Reference<ProjectManager, Long> projectManager) {
		this.projectManager = projectManager;
	}
	
}
