package com.eventapplication.eventapplication.controllers;

import com.eventapplication.eventapplication.common.ConstantMessage;
import com.eventapplication.eventapplication.common.ResponseBuilder;
import com.eventapplication.eventapplication.models.request.LoginReq;
import com.eventapplication.eventapplication.services.AuthService;
import com.eventapplication.eventapplication.services.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/login",consumes = "application/json")
    public ResponseEntity<ResponseBuilder> login(@Valid @RequestBody LoginReq loginReq){
        return ResponseEntity.ok().body(new ResponseBuilder().setMassage(ConstantMessage.LOGIN_SUCCESSFULLY.getValue()).setData(authService.loginUser(loginReq)).build());
    }

}
