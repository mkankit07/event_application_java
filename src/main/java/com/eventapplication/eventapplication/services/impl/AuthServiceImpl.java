package com.eventapplication.eventapplication.services.impl;

import com.eventapplication.eventapplication.common.ConstantMessage;
import com.eventapplication.eventapplication.entity.User;
import com.eventapplication.eventapplication.exceptions.ResourceNotFoundException;
import com.eventapplication.eventapplication.mapper.UserMapper;
import com.eventapplication.eventapplication.models.request.LoginReq;
import com.eventapplication.eventapplication.models.request.RagisterReq;
import com.eventapplication.eventapplication.models.response.AuthRes;
import com.eventapplication.eventapplication.models.response.LoginRes;
import com.eventapplication.eventapplication.repository.UserRepository;
import com.eventapplication.eventapplication.services.AuthService;
import com.eventapplication.eventapplication.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    @Override
    public LoginRes loginUser(LoginReq loginReq) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(),loginReq.getPassword()));
        User user=userRepository.findByEmail(loginReq.getEmail()).orElseThrow(()->new ResourceNotFoundException(ConstantMessage.INVALID_USER_DETAILS.getValue()));
       AuthRes authRes= userMapper.userToAuthRes(user);
        if(!passwordEncoder.matches(loginReq.getPassword(),authRes.getPassword())){
            throw new ResourceNotFoundException(ConstantMessage.INVALID_USER_DETAILS.getValue());
        }
        String token = JwtService.generateToken(authRes.getId());
        return new LoginRes(authRes.getId(),token);
    }

    @Override
    public String saveUser(RagisterReq ragisterReq) {
        return null;
    }

}
