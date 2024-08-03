package com.jiaul.virtualtutor.user;

import com.jiaul.virtualtutor.authconfig.JwtService;
import com.jiaul.virtualtutor.customexception.UserNotFoundException;
import com.jiaul.virtualtutor.entities.jwt.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserCredentialService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Autowired
    private JwtTokenService jwtTokenService;

    public UserCredential createUserCredential(UserCredential userCredential){
        return userCredentialRepository.save(userCredential);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userCredentialRepository.findByEmail(username).orElseThrow();
    }

    public UserCredential getUserCredentialByEmail(String email){
        return userCredentialRepository.findByEmail(email).orElseThrow();
    }

    public Optional<UserCredential> getUser(int id) throws UserNotFoundException {
        Optional<UserCredential> ourUser= userCredentialRepository.findById(id);
        if(ourUser==null){
            throw new UserNotFoundException("User Not Found "+id);
        }
        return ourUser;
    }

    public ResponseEntity<Optional<UserCredential>> getAllUser() {
        return (ResponseEntity<Optional<UserCredential>>) userCredentialRepository.findAll();
    }

    @Transactional
    public String updateActiveStatus(String email, boolean enabled){
        if(userCredentialRepository.updateEnabledByEmail(enabled,email)==1){
            return "SUCCESS";
        }
        return "FAILED";
    }
}
