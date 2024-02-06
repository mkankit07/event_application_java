package com.eventapplication.eventapplication.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginReq {
    @NotNull(message = "email must be required")
    private String email;
    @NotNull(message = "email must be required")
    private String password;
}
