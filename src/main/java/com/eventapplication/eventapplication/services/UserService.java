package com.eventapplication.eventapplication.services;

import com.eventapplication.eventapplication.models.request.LoginReq;
import com.eventapplication.eventapplication.models.request.RegisterReq;
import com.eventapplication.eventapplication.models.response.LoginRes;
import com.eventapplication.eventapplication.models.response.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserResponseDTO saveUser(RegisterReq registerReq);
    public LoginRes loginUser(LoginReq loginReq);

    public List<UserResponseDTO> getUsers(String search,String limit,String offset);


}
