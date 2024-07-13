package com.jiaul.virtualtutor.entities.teacher;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.common.CommonProfileInfo;
import com.jiaul.virtualtutor.entities.common.Education;
import com.jiaul.virtualtutor.entities.common.Experience;
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
public class Teacher extends CommonProfileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private List<String> skills;
    private String degree;

    @OneToOne
    private UserCredential userCredential;

    @OneToMany(mappedBy = "courseTeacher")
    private List<Course> sellCourses;

//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    private List<Education> educations;
//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    private List<Experience> experiences;
}
