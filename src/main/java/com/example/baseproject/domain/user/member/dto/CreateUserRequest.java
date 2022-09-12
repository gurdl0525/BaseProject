package com.example.baseproject.domain.user.member.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserRequest {

    private final String accountId;

    private final String password;

}
