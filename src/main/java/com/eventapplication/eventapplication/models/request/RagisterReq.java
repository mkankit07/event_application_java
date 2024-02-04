package com.eventapplication.eventapplication.models.request;

import com.eventapplication.eventapplication.enums.Status;
import lombok.Getter;

@Getter
public class RagisterReq {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String bio;
    private Status status= Status.ACTIVE;
}
