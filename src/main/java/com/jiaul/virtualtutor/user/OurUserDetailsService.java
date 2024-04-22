package com.jiaul.virtualtutor.user;

import com.jiaul.virtualtutor.customexception.UserNotFoundExcepthon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OurUserDetailsService implements UserDetailsService {

    @Autowired
    OurUserRepository ourUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ourUserRepository.findByEmail(username).orElseThrow();
    }

    public Optional<OurUser> getUser(int id) throws UserNotFoundExcepthon {
        Optional<OurUser> ourUser= ourUserRepository.findById(id);
        if(ourUser==null){
            throw new UserNotFoundExcepthon("User Not Found "+id);
        }
        return ourUser;
    }

    public ResponseEntity<Optional<OurUser>> getAllUser() {
        return (ResponseEntity<Optional<OurUser>>) ourUserRepository.findAll();
    }
}
