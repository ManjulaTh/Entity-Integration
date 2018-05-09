package com.cooksys.dto;

import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.cooksys.dto.datatype.Reference;
import com.cooksys.entity.Project;
import com.cooksys.validation.UniqueFirstAndLast;

@UniqueFirstAndLast
public class ProjectManagerDto {
	
	private Long id;
	@NotBlank(message = "firstName can not be blank")
	private String firstName;
	@NotBlank(message = "lastName can not blank")
	private String lastName;
	@Size(max = 3,message = "One manager can not have more than 3 projects")
	private Set<Reference<Project, Long>> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Reference<Project, Long>> getProjects() {
		return projects;
	}

	public void setProjects(Set<Reference<Project, Long>> projects) {
		this.projects = projects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProjectManagerDto other = (ProjectManagerDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
