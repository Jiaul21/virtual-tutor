package com.jiaul.virtualtutor.entities.course;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.meeting.Meeting;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import com.jiaul.virtualtutor.entities.student.Student;
import com.jiaul.virtualtutor.entities.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
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
    private String duration;    // 8 weeks or 10 hours
    private String description;
    private float rating;
    private float price;
    private float offer;
    private Date publishingDateTime;
    private boolean isActive;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseModule> courseModules;

    @ManyToMany(mappedBy = "buyCourses", cascade = CascadeType.ALL)
    private List<Student> courseStudents;

    @ManyToOne
    private Teacher courseTeacher;

    @OneToOne
    private Meeting meeting;
}
