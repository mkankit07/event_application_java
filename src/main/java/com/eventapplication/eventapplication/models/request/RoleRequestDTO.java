package com.eventapplication.eventapplication.models.request;

import com.eventapplication.eventapplication.enums.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class RoleRequestDTO {
    private String title;
    private Status status=Status.ACTIVE;
}
