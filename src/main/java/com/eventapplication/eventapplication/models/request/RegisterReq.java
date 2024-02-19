package com.eventapplication.eventapplication.models.request;

import com.eventapplication.eventapplication.entity.Role;
import com.eventapplication.eventapplication.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder(toBuilder = true)
public class RegisterReq {

    @NotNull(message = "firstName must be required")
    private String firstName;

    @NotNull(message = "lastName must be required")
    private String lastName;

    @NotNull(message = "email must be required")
    private String email;

    @NotNull(message = "password must be required")
    private String password;

    private String bio;

    private Status status= Status.ACTIVE;

    private Set<String> roles;
}
