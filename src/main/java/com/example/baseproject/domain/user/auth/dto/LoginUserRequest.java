package com.example.baseproject.domain.user.auth.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class LoginUserRequest {

    private final String accountId;

    private final String password;

}
