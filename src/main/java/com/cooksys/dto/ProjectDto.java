package com.cooksys.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.cooksys.dto.datatype.Reference;
import com.cooksys.entity.ProjectManager;
import com.cooksys.validation.NotMoreThanTwentyYears;


public class ProjectDto {
	private Long id;	
	@NotMoreThanTwentyYears(message = "Start Date must be in the range of -20 Years - Current Year - +10 Years")
	private Date startDate;
	@NotNull(message = "Must enter valid due date")
	private Date dueDate;
	@NotNull(message = "projectManager.notempty")
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
