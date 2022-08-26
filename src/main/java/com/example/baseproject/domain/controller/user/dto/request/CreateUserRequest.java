package com.example.baseproject.domain.controller.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserRequest {

    private final String accountId;

    private final String password;

}
