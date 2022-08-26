package com.example.baseproject.domain.controller.auth.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginUserRequest {

    private final String accountId;

    private final String password;

}
