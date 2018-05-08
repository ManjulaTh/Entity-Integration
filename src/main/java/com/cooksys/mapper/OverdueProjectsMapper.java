package com.cooksys.mapper;

import org.mapstruct.Mapper;

import com.cooksys.dto.OverdueProjectsDto;
import com.cooksys.entity.ProjectManager;

@Mapper(componentModel = "spring", uses = { ReferenceMapper.class })
public interface OverdueProjectsMapper {

	//OverdueProjectsMapper toDto( entity);

	//ProjectManager toEntity(OverdueProjectsMapper dto);

}