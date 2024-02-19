package com.eventapplication.eventapplication.models.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class RoleResponseDTO {
    private UUID id;
    private String title;
}
