package com.example.baseproject.domain.controller.user;

import com.example.baseproject.domain.controller.auth.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.user.dto.request.CreateUserRequest;
import com.example.baseproject.domain.controller.user.dto.response.MessageResponse;
import com.example.baseproject.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse join(@RequestBody CreateUserRequest request){
        return userService.join(request);
    }

    @PatchMapping("/compilation")
    public MessageResponse compilation(@RequestBody LoginUserRequest request){
        return userService.editMember(request);
    }
}
