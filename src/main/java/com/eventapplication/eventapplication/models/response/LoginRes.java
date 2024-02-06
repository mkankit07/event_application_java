package com.eventapplication.eventapplication.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class LoginRes {
    private UUID userId;
    private String token;

}
