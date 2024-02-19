package com.eventapplication.eventapplication.controllers;

import com.eventapplication.eventapplication.entity.Role;
import com.eventapplication.eventapplication.models.request.RoleRequestDTO;
import com.eventapplication.eventapplication.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    @PostMapping
    public Role createRole(@RequestBody RoleRequestDTO roleRequestDTO){
        return roleService.createRole(roleRequestDTO);
    }
}
