package com.eventapplication.eventapplication.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginReq {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
