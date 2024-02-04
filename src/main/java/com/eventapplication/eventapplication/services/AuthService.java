package com.eventapplication.eventapplication.services;

import com.eventapplication.eventapplication.models.request.LoginReq;
import com.eventapplication.eventapplication.models.request.RagisterReq;
import com.eventapplication.eventapplication.models.response.LoginRes;



public interface AuthService {
    public LoginRes loginUser(LoginReq loginReq);
    public String saveUser(RagisterReq ragisterReq);
}
