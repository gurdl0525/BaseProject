package com.example.baseproject.domain.entity.redis;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@AllArgsConstructor
@RedisHash(timeToLive = 60 * 60 * 24 * 14)
public class RefreshToken {
    @Id
    private final String id;
    @Indexed
    private final String refreshToken;
}
