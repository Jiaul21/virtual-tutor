package com.jiaul.virtualtutor.user;

import com.jiaul.virtualtutor.customexception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user-credential")
public class UserCredentialController {

    @Autowired
    UserCredentialService userCredentialService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserCredential>> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userCredentialService.getUser(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Optional<UserCredential>> getAllUser(){
        return  ResponseEntity.ok(userCredentialService.getAllUser().getBody());
    }
}
