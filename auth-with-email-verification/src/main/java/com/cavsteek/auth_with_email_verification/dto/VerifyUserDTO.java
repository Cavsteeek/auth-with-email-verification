package com.cavsteek.auth_with_email_verification.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyUserDTO
{
    private String email;
    private String verificationCode;
}
