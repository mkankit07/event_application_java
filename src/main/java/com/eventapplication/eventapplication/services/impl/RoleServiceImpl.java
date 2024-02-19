package com.eventapplication.eventapplication.services.impl;

import com.eventapplication.eventapplication.entity.Role;
import com.eventapplication.eventapplication.exceptions.ResourceNotFoundException;
import com.eventapplication.eventapplication.mapper.RoleMapper;
import com.eventapplication.eventapplication.models.request.RoleRequestDTO;
import com.eventapplication.eventapplication.repository.RoleRepository;
import com.eventapplication.eventapplication.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    public Role createRole(RoleRequestDTO roleRequestDTO) {
        return roleRepository.save(roleMapper.dtoToRole(roleRequestDTO));
    }

    @Override
    public Role getUserByName(String role) {
        return roleRepository.findByTitle(role).orElseThrow(()-> new ResourceNotFoundException("Role not found"));
    }
}
