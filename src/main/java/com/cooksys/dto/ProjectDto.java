package com.cooksys.dto;

import java.util.Date;

import com.cooksys.dto.datatype.Reference;
import com.cooksys.entity.Project;
import com.cooksys.entity.ProjectManager;


public class ProjectDto {
	private int id;
	private Date startDate ;
	private Date dueDate;
	private Boolean overdue;
	private Reference<ProjectManager, Long> projectManager;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectDto other = (ProjectDto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Boolean getOverdue() {
		return overdue;
	}
	public void setOverdue(Boolean overdue) {
		this.overdue = overdue;
	}
	
	

}
