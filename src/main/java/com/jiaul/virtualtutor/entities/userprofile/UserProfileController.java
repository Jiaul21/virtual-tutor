package com.jiaul.virtualtutor.entities.userprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUserProfile(@RequestBody UserProfile userProfile){
        return ResponseEntity.ok(userProfileService.createUserProfile(userProfile));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateUserProfile(@RequestBody UserProfile userProfile){
        return ResponseEntity.ok(userProfileService.updateUserProfile(userProfile));
    }

}
