package com.eventapplication.eventapplication.services.impl;

import com.eventapplication.eventapplication.common.Constant;
import com.eventapplication.eventapplication.entity.User;
import com.eventapplication.eventapplication.exceptions.ConflictException;
import com.eventapplication.eventapplication.exceptions.ResourceNotFoundException;
import com.eventapplication.eventapplication.mapper.UserMapper;
import com.eventapplication.eventapplication.models.request.LoginReq;
import com.eventapplication.eventapplication.models.request.RegisterReq;
import com.eventapplication.eventapplication.models.response.AuthRes;
import com.eventapplication.eventapplication.models.response.LoginRes;
import com.eventapplication.eventapplication.models.response.UserResponseDTO;
import com.eventapplication.eventapplication.repository.UserRepository;
import com.eventapplication.eventapplication.services.UserService;
import com.eventapplication.eventapplication.utils.JwtService;
import com.eventapplication.eventapplication.utils.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    @Override
    public LoginRes loginUser(LoginReq loginReq) {
        User user=userRepository.findByEmail(loginReq.getEmail()).orElseThrow(()->new ResourceNotFoundException(Constant.INVALID_USER_DETAILS));
        AuthRes authRes= userMapper.userToAuthRes(user);
        if(!passwordEncoder.matches(loginReq.getPassword(),authRes.getPassword())){
            throw new ResourceNotFoundException(Constant.INVALID_USER_DETAILS);
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(),loginReq.getPassword()));
        String token = JwtService.generateToken(authRes.getId());
        return new LoginRes(authRes.getId(),token);
    }

    @Override
    public UserResponseDTO saveUser(RegisterReq registerReq) {
        if(userRepository.existsByEmail(registerReq.getEmail())){
            throw new ConflictException(Constant.USER_CONFLICT);
        }
        registerReq = registerReq.toBuilder().password(passwordEncoder.encode(registerReq.getPassword())).build();
        User user= userRepository.save(userMapper.userDtoToUser(registerReq));
        return userMapper.userToUserResponse(user);
    }

    @Override
    public List<UserResponseDTO> getUsers(String search, String limit, String offset){
        Pageable pageable= PageRequest.of((Integer.parseInt(offset)-1)*Integer.parseInt(limit),Integer.parseInt(limit), Sort.Direction.DESC ,"createdAt");
        Specification<User> filter=Specification.where(null);
        if( search !=null && !search.isEmpty()){
            filter=   filter.and(UserSpecification.hasFirstName(search));
            filter=   filter.or( UserSpecification.hasLastName(search));
        }

        Page<User> userPage=  userRepository.findAll(filter,pageable);
        return userPage.getContent().stream().map(userMapper::userToUserResponse).toList();
    }


}
