package com.eventapplication.eventapplication.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class LoginRes {
    private UUID userId;
    private String token;

}
