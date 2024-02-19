package com.eventapplication.eventapplication.models.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
public class UserResponseDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String bio;
    private String email;
    private Date createdAt;
    private List<RoleResponseDTO> roles;
}
