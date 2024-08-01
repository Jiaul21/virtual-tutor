package com.jiaul.virtualtutor.entities.module;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.assessment.assignment.Assignment;
import com.jiaul.virtualtutor.entities.assessment.mcqtest.McqTest;
import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.entities.discussion.Discussion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CourseModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String topics;  // specific topic
    private String thumbnail;
    private String contentType; // video or pdf
    private String contentName;
    private String contentSource;
    private Date publishingDateTime;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "courseModule",cascade = CascadeType.ALL)
    private List<Discussion> discussions;


//    @OneToMany(mappedBy = "courseModule", cascade = CascadeType.ALL)
//    private List<Assignment> assignments;
//
//    @OneToOne
//    private McqTest mcqTest;
}
