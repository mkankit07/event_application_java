package com.eventapplication.eventapplication.mapper;

import com.eventapplication.eventapplication.entity.User;
import com.eventapplication.eventapplication.models.response.AuthRes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    AuthRes userToAuthRes(User user);

}
