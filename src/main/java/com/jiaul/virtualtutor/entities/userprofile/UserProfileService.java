package com.jiaul.virtualtutor.entities.userprofile;

import com.jiaul.virtualtutor.user.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile updateUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getUserProfileById(int id){
        return userProfileRepository.findById(id).orElseThrow();
    }
}
