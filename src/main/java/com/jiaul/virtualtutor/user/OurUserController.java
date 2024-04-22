package com.jiaul.virtualtutor.user;

import com.jiaul.virtualtutor.customexception.UserNotFoundExcepthon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/our-user")
public class OurUserController {

    @Autowired
    OurUserDetailsService ourUserDetailsService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<OurUser>> getUser(@PathVariable int id) throws UserNotFoundExcepthon {
        return ResponseEntity.ok(ourUserDetailsService.getUser(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Optional<OurUser>> getAllUser(){
        return  ResponseEntity.ok(ourUserDetailsService.getAllUser().getBody());
    }
}
