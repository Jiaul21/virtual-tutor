package com.jiaul.virtualtutor.authaccount;

import com.jiaul.virtualtutor.Test;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("/account")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> LogIn(@RequestBody @Valid LoginRequest loginRequest) {
        System.out.println(loginRequest);
        return ResponseEntity.ok(authService.logIn(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<RegistrationResponse> signUp(@RequestBody @Valid RegistrationRequest registrationRequest) {
        System.out.println("=============== SignUp ================");
        return ResponseEntity.ok(authService.signUp(registrationRequest));
    }

    @GetMapping("/hello")
    public String hello(@RequestBody @Valid Test test){

        return "Hello";
    }

}
