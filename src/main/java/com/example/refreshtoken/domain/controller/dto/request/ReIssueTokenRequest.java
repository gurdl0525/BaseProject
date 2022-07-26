package com.example.refreshtoken.domain.controller.dto.request;

import com.sun.istack.NotNull;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReIssueTokenRequest {
    @NotNull
    private String refreshToken;
}
