package com.example.baseproject.domain.user.auth.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReIssueTokenRequest {
    private String refreshToken;
}
