package com.eventapplication.eventapplication.services;

import com.eventapplication.eventapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;


}
