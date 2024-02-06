package com.eventapplication.eventapplication.controllers;

import com.eventapplication.eventapplication.common.Constant;
import com.eventapplication.eventapplication.common.ResponseBuilder;
import com.eventapplication.eventapplication.models.request.LoginReq;
import com.eventapplication.eventapplication.models.request.RegisterReq;
import com.eventapplication.eventapplication.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth")
@RequiredArgsConstructor
@Tag(name = "auth")
public class AuthController {
    private final UserService userService;

    @PostMapping(value = "/login",consumes = "application/json")
    public ResponseEntity<ResponseBuilder> login(@Valid @RequestBody LoginReq loginReq){
        return ResponseEntity.ok().body(new ResponseBuilder().setMassage(Constant.LOGIN_SUCCESSFULLY).setStatus(HttpStatus.OK.value()).setData(userService.loginUser(loginReq)).build());
    }
    @PostMapping(value = "/register",consumes = "application/json")
    public ResponseEntity<ResponseBuilder> register(@Valid @RequestBody RegisterReq registerReq){
        return ResponseEntity.ok().body(new ResponseBuilder().setMassage(Constant.USER_CREATED).setStatus(HttpStatus.CREATED.value()).setData(userService.saveUser(registerReq)).build());
    }

}
