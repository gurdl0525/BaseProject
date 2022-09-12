package com.example.baseproject.domain.user.member.controller;

import com.example.baseproject.domain.user.auth.dto.LoginUserRequest;
import com.example.baseproject.domain.user.member.dto.CreateUserRequest;
import com.example.baseproject.global.common.MessageResponse;
import com.example.baseproject.domain.user.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse join(@RequestBody CreateUserRequest request){
        return userService.join(request);
    }

    @PatchMapping("/compilation")
    public MessageResponse compilation(@RequestBody LoginUserRequest request){
        return userService.editMember(request);
    }
}
