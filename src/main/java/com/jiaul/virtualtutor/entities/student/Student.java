package com.jiaul.virtualtutor.entities.student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.common.CommonProfileInfo;
import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.user.UserCredential;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student extends CommonProfileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private UserCredential userCredential;

    @ManyToMany
    private List<Course> buyCourses;
}
