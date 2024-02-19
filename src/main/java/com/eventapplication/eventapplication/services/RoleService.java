package com.eventapplication.eventapplication.services;

import com.eventapplication.eventapplication.entity.Role;
import com.eventapplication.eventapplication.models.request.RoleRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    public Role createRole(RoleRequestDTO roleRequestDTO);

    public Role getUserByName(String role);
}
