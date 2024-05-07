package com.jiaul.virtualtutor.authaccount;

import com.jiaul.virtualtutor.authaccount.dto.AuthResponse;
import com.jiaul.virtualtutor.authaccount.dto.LoginRequest;
import com.jiaul.virtualtutor.authaccount.dto.RegistrationRequest;
import com.jiaul.virtualtutor.authconfig.entity.JwtToken;
import com.jiaul.virtualtutor.authconfig.entity.JwtTokenService;
import com.jiaul.virtualtutor.entities.userprofile.UserProfile;
import com.jiaul.virtualtutor.entities.userprofile.UserProfileService;
import com.jiaul.virtualtutor.user.UserCredential;
import com.jiaul.virtualtutor.user.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserCredentialService userCredentialService;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse logIn(LoginRequest loginRequest) {
        AuthResponse authResponse = new AuthResponse();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            UserProfile userProfile = userCredentialService.getUserCredentialByEmail(loginRequest.getEmail()).getUserProfile();
            JwtToken newToken = jwtTokenService.createJwtTokenByUserProfile(userProfile);
            JwtToken token = jwtTokenService.saveToken(newToken);
            if (token != null) {
                String message = "User Login Successfully";
                authResponse = makeAuthResponse(userProfile, token, message);
            }
        } catch (Exception e) {
            authResponse.setMessage("Bad Credential ! Try Right User & Password. " + e.getMessage());
        }
        return authResponse;
    }

    public AuthResponse signUp(RegistrationRequest registrationRequest) {
        AuthResponse authResponse = new AuthResponse();

        UserProfile userProfile = new UserProfile();
        userProfile.setName(registrationRequest.getName());

        UserCredential userCredential = new UserCredential();
        userCredential.setEmail(registrationRequest.getEmail());
        userCredential.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userCredential.setRole(registrationRequest.getRole());
        userCredential.setAccountNonExpired(true);
        userCredential.setAccountNonLocked(true);
        userCredential.setCredentialsNonExpired(true);
        userCredential.setEnabled(true);
        userCredential.setUserProfile(userProfile);

        try {
            userProfile.setUserCredential(userCredential);
            JwtToken newToken = jwtTokenService.createJwtTokenByUserProfile(userProfile);
            userProfile.setJwtTokens(List.of(newToken));

            UserProfile userProfile1 = userProfileService.createUserProfile(userProfile);
            if (userProfile1 != null) {
                String message = "User account Created & Login Successfully";
                authResponse = makeAuthResponse(userProfile1, newToken, message);
            }
        } catch (Exception e) {
            authResponse.setMessage("Internal Server Error. " + e.getMessage());
        }
        return authResponse;
    }

    public AuthResponse makeAuthResponse(UserProfile userProfile, JwtToken token, String message) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(userProfile.getId());
        authResponse.setName(userProfile.getName());
        authResponse.setEmail(userProfile.getUserCredential().getEmail());
        authResponse.setRole(userProfile.getUserCredential().getRole());
        authResponse.setPhoto(userProfile.getPhoto());
        authResponse.setMessage(message);
        authResponse.setJwtToken(token.getToken());
        authResponse.setJwtTokenType(token.getTokenType());
        return authResponse;
    }


}
