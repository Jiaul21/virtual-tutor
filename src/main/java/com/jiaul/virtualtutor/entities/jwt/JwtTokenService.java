package com.jiaul.virtualtutor.entities.jwt;

import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.user.UserCredential;
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

    public JwtToken createJwtTokenByUserCredential(UserCredential userCredential){
        JwtToken jwtToken = new JwtToken();
        jwtToken.setTokenValue(jwtService.generateToken(userCredential));
//        jwtService.generateRefreshToken(new HashMap<>(), ourUser);
        jwtToken.setTokenType("Bearer ");
        jwtToken.setNonExpired(true);
        jwtToken.setNonRevoked(true);
        jwtToken.setUserCredential(userCredential);
        return jwtToken;
    }

    public JwtToken updateTokenValueByUserCredential(UserCredential userCredential){
        userCredential.getJwtToken().setTokenValue(jwtService.generateToken(userCredential));
        userCredential.getJwtToken().setNonExpired(true);
        userCredential.getJwtToken().setNonRevoked(true);
        return jwtTokenRepository.save(userCredential.getJwtToken());
    }

    public void revokeToken(JwtToken jwtToken){
        jwtToken.setNonRevoked(false);
        jwtTokenRepository.save(jwtToken);
    }
}
