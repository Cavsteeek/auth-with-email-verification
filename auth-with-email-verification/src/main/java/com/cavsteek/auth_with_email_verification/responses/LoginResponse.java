package com.cavsteek.auth_with_email_verification.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private long expiresIn;
}
