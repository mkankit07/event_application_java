package com.eventapplication.eventapplication.controllers;

import com.eventapplication.eventapplication.common.Constant;
import com.eventapplication.eventapplication.common.ResponseBuilder;
import com.eventapplication.eventapplication.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
@SecurityRequirement( name = "Bearer Authentication")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResponseBuilder> getUsers(@RequestParam(required = false) String  search,@RequestParam(defaultValue = "10") String limit,@RequestParam(defaultValue = "1") String offset  ){
        return ResponseEntity.ok().body(new ResponseBuilder().setMassage("user found").setStatus(HttpStatus.OK.value()).setData(userService.getUsers(search,limit,offset)).build());
    }
}
