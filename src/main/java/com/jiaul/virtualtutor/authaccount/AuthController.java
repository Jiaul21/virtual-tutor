package com.jiaul.virtualtutor.authaccount;

import com.jiaul.virtualtutor.authaccount.dto.AuthResponse;
import com.jiaul.virtualtutor.authaccount.dto.LoginRequest;
import com.jiaul.virtualtutor.authaccount.dto.RegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> LogIn(@RequestBody @Valid LoginRequest loginRequest) {
        System.out.println(loginRequest);
        return ResponseEntity.ok(authService.logIn(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody @Valid RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(authService.signUp(registrationRequest));
    }

}
