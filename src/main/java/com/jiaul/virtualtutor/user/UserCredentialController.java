package com.jiaul.virtualtutor.user;

import com.jiaul.virtualtutor.customexception.UserNotFoundExcepthon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/our-user")
public class UserCredentialController {

    @Autowired
    UserCredentialService userCredentialService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserCredential>> getUser(@PathVariable int id) throws UserNotFoundExcepthon {
        return ResponseEntity.ok(userCredentialService.getUser(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Optional<UserCredential>> getAllUser(){
        return  ResponseEntity.ok(userCredentialService.getAllUser().getBody());
    }
}
