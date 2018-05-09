package com.cooksys.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cooksys.dto.ProjectManagerDto;
import com.cooksys.entity.ProjectManager;
import com.cooksys.repository.ProjectManagerRepository;

public class UniqueFirstAndLastValidator implements ConstraintValidator<UniqueFirstAndLast, ProjectManagerDto>{

	private ProjectManagerRepository pmRepo;

	public UniqueFirstAndLastValidator(ProjectManagerRepository pmRepo) {
		System.out.println("<----- INITIALIZING ----->");
		this.pmRepo = pmRepo;
	}
	
	@Override
	public void initialize(UniqueFirstAndLast arg0) {
	}

	@Override
	public boolean isValid(ProjectManagerDto manager, ConstraintValidatorContext context) {
		return !pmRepo.existsByFirstNameAndLastName(manager.getFirstName(), manager.getLastName());
	}

}
