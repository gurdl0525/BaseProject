package com.example.baseproject.domain.user.auth.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@RequiredArgsConstructor
@RedisHash(timeToLive = 7200)
public class RefreshToken {

    @Id
    private final String id;

    @Indexed
    private final String refreshToken;

}
