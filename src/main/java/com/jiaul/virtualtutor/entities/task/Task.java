package com.jiaul.virtualtutor.entities.task;

import com.jiaul.virtualtutor.entities.assessment.assignment.Assignment;
import com.jiaul.virtualtutor.entities.assessment.mcqtest.McqTest;
import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String taskType;
    private Date dateTime;
    private boolean isDone;

    @OneToOne
    private CourseModule courseModule;

}
