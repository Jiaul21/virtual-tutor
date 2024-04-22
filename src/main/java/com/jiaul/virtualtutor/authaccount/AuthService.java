package com.jiaul.virtualtutor.authaccount;

import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.response.AuthResponse;
import com.jiaul.virtualtutor.response.HttpResponse;
import com.jiaul.virtualtutor.user.OurUser;
import com.jiaul.virtualtutor.user.OurUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private OurUserRepository ourUserRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    public LoginResponse logIn(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            var user = ourUserRepository.findByEmail(loginRequest.getEmail()).orElseThrow();

            loginResponse.setName(user.getName());
            loginResponse.setEmail(user.getEmail());
            loginResponse.setRole(user.getRole());
            loginResponse.setAuthResponse(new AuthResponse(jwtService.generateToken(user),
                    jwtService.generateRefreshToken(new HashMap<>(), user), jwtService.getExpirationTime()));
            loginResponse.setHttpResponse(new HttpResponse("200","non","LogIn Successfully"));
        } catch (Exception e) {
            loginResponse.setHttpResponse(new HttpResponse("401",e.getMessage(),"Bad Credential ! Try Right User & Password"));
        }
        return loginResponse;
    }

    public RegistrationResponse signUp(RegistrationRequest registrationRequest) {
        RegistrationResponse registrationResponse=new RegistrationResponse();
        try {
            OurUser ourUser = new OurUser();
            ourUser.setName(registrationRequest.getName());
            ourUser.setEmail(registrationRequest.getEmail());
            ourUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            ourUser.setRole(registrationRequest.getRole());
            ourUser.setAccountNonExpired(true);
            ourUser.setAccountNonLocked(true);
            ourUser.setCredentialsNonExpired(true);
            ourUser.setEnabled(true);

            System.out.println("ourUser: "+ourUser);

            var user = ourUserRepository.save(ourUser);
            System.out.println("user: "+user);
            if (user != null && user.getId() > 0) {
                registrationResponse.setHttpResponse(new HttpResponse("201","non","SignUp Successfully"));
                try{
//                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
                    registrationResponse.setName(user.getName());
                    registrationResponse.setEmail(user.getEmail());
                    registrationResponse.setRole(user.getRole());
                    registrationResponse.setAuthResponse(new AuthResponse(jwtService.generateToken(user),
                            jwtService.generateRefreshToken(new HashMap<>(), user), jwtService.getExpirationTime()));
                    registrationResponse.setHttpResponse(new HttpResponse("201","non","SignUp & LogIn Successfully"));
                }catch (Exception e){
                    registrationResponse.setHttpResponse(new HttpResponse("500",e.getMessage(),"Login Failed"));
                }
            }
        } catch (Exception e) {
            registrationResponse.setHttpResponse(new HttpResponse("500",e.getMessage(),"SignUp Failed"));
        }
        return registrationResponse;
    }


}
