package com.eventapplication.eventapplication.models.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Builder
public class AuthRes {
    private UUID id;
    private String password;
    private String email;
}
