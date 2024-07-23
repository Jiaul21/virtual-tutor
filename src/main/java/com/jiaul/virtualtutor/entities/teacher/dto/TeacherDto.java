package com.jiaul.virtualtutor.entities.teacher.dto;

import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.user.UserCredential;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Base64;
import java.util.List;

@Data
public class TeacherDto {

    private int id;
    private String firstName;
    private String lastName;
    private String photo;
    private String phone;
    private String gender;
    private String language;
    private String country;
    private String city;
    private String bio;
    private String degree;
    private List<String> skills;
    private int totalSell;
    private boolean isActive;

    private UserCredential userCredential;
    private List<Course> sellCourses;

}
