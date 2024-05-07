package com.jiaul.virtualtutor.authconfig.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.userprofile.UserProfile;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class JwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String token;
    private String tokenType;
    private boolean isExpired;
    private boolean isRevoked;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;
}
