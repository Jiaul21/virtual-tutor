package com.jiaul.virtualtutor.entities.course;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import com.jiaul.virtualtutor.entities.userprofile.UserProfile;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String image;
    private String type;        // ongoing or ready
    private String category;    // academic or skills
    private String description;
    private float rating;
    private float price;
    private float offer;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private UserProfile instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseModule> courseModules;

    @ManyToMany
    private List<UserProfile> students;
}
