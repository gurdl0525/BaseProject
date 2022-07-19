package com.example.refreshtoken.domain.controller;

import com.example.refreshtoken.domain.controller.dto.request.UserRequest;
import com.example.refreshtoken.domain.controller.dto.response.MessageResponse;
import com.example.refreshtoken.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/account")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponse join(@RequestBody UserRequest request){
        return userService.join(request);
    }
}
