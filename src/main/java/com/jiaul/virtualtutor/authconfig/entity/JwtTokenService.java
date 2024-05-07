package com.jiaul.virtualtutor.authconfig.entity;

import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.entities.userprofile.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    public JwtToken saveToken(JwtToken jwtToken) {
        return jwtTokenRepository.save(jwtToken);
    }

    public JwtToken createJwtTokenByUserProfile(UserProfile userProfile) {
        JwtToken jwtToken = new JwtToken();
        jwtToken.setToken(jwtService.generateToken(userProfile.getUserCredential()));
//        jwtService.generateRefreshToken(new HashMap<>(), ourUser);
        jwtToken.setTokenType("Bearer ");
        jwtToken.setExpired(false);
        jwtToken.setRevoked(false);
        jwtToken.setUserProfile(userProfile);
        return jwtToken;
    }
}
