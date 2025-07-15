package com.cavsteek.auth_with_email_verification.controller;

import com.cavsteek.auth_with_email_verification.dto.LoginUserDTO;
import com.cavsteek.auth_with_email_verification.dto.RegisterUserDTO;
import com.cavsteek.auth_with_email_verification.dto.VerifyUserDTO;
import com.cavsteek.auth_with_email_verification.model.User;
import com.cavsteek.auth_with_email_verification.responses.LoginResponse;
import com.cavsteek.auth_with_email_verification.service.AuthenticationService;
import com.cavsteek.auth_with_email_verification.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> register (@RequestBody RegisterUserDTO registerUserDTO){
        User registeredUser = authenticationService.signup(registerUserDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto){
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser (@RequestBody VerifyUserDTO verifyUserDTO){
        try{
            authenticationService.verifyUser(verifyUserDTO);
            return ResponseEntity.ok("Account verified successfully");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendVerificationCOde(@RequestParam String email){
        try {
            authenticationService.resendVerificationCode(email);
            return ResponseEntity.ok("Verification code sent");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
