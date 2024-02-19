package com.eventapplication.eventapplication.mapper;

import com.eventapplication.eventapplication.entity.Role;
import com.eventapplication.eventapplication.entity.User;
import com.eventapplication.eventapplication.models.request.RegisterReq;
import com.eventapplication.eventapplication.models.response.AuthRes;
import com.eventapplication.eventapplication.models.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    AuthRes userToAuthRes(User user);

    UserResponseDTO userToUserResponse(User user);
    default Set<String> rolesToStringSet(Set<Role> roles) {
        if (roles == null) {
            return null;
        }
        return roles.stream()
                .map(Role::getTitle)
                .collect(Collectors.toSet());
    }
}
