package com.jiaul.virtualtutor.entities.module;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.content.Content;
import com.jiaul.virtualtutor.entities.course.Course;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

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
    private String duration;    // 8 weeks or 10 hours
    private Date publishingDate;
    private Date publishingTime;
    private String contentType; // video or pdf

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    private Content content;

}
