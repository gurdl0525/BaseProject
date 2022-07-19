package com.example.refreshtoken.domain.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@Table
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rf_token")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "password")
    private String password;
}
