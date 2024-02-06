package com.eventapplication.eventapplication.mapper;

import com.eventapplication.eventapplication.entity.User;
import com.eventapplication.eventapplication.models.request.RegisterReq;
import com.eventapplication.eventapplication.models.response.AuthRes;
import com.eventapplication.eventapplication.models.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    AuthRes userToAuthRes(User user);
    User userDtoToUser(RegisterReq registerReq);

    UserResponseDTO userToUserResponse(User user);
}
