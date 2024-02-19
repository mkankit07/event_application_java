package com.eventapplication.eventapplication.mapper;

import com.eventapplication.eventapplication.entity.Role;
import com.eventapplication.eventapplication.models.request.RoleRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role dtoToRole(RoleRequestDTO roleRequestDTO);
}
