package com.jiaul.virtualtutor.user;

import com.jiaul.virtualtutor.customexception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialService implements UserDetailsService {

    @Autowired
    UserCredentialRepository userCredentialRepository;

    public UserCredential createUserCredential(UserCredential userCredential){
        System.out.println("-------------------------------------- 1 --------------------");
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
}
