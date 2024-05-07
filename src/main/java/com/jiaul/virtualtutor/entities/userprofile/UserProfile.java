package com.jiaul.virtualtutor.entities.userprofile;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.authconfig.entity.JwtToken;
import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.user.UserCredential;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    private UserCredential userCredential;

    @OneToMany(mappedBy = "instructor")
    private List<Course> sellCourses;

    @ManyToMany
    private List<Course> buyCourses;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<JwtToken> jwtTokens;

}
