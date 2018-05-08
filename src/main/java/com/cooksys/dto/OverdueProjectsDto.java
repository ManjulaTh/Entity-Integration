package com.cooksys.dto;

public class OverdueProjectsDto {
	private Long projectManagerId;
	private Long numberOfOverdueProjects;
	
	
	public OverdueProjectsDto(Long projectManagerId, Long numberOfOverdueProjects) {
		this.projectManagerId = projectManagerId;
		this.numberOfOverdueProjects = numberOfOverdueProjects;
	}
	
	
	public Long getProjectManagerId() {
		return projectManagerId;
	}
	public void setProjectManagerId(Long projectManagerId) {
		this.projectManagerId = projectManagerId;
	}
	public Long getNumberOfOverdueProjects() {
		return numberOfOverdueProjects;
	}
	public void setNumberOfOverdueProjects(Long numberOfOverdueProjects) {
		this.numberOfOverdueProjects = numberOfOverdueProjects;
	}
	
	
	
}
