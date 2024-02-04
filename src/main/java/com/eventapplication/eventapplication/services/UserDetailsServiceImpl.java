package com.eventapplication.eventapplication.services;

import com.eventapplication.eventapplication.common.ConstantMessage;
import com.eventapplication.eventapplication.entity.User;
import com.eventapplication.eventapplication.exceptions.ResourceNotFoundException;
import com.eventapplication.eventapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username).orElseThrow(() ->
                new ResourceNotFoundException(String.format(ConstantMessage.USER_NOT_FOUND.getValue())));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
