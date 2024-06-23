package com.jiaul.virtualtutor.entities.assignment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.assignmentanswer.AssignmentAnswer;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int assignmentNo;
    private String questionType;
    private String assignmentSource;

    @ManyToOne
    private CourseModule courseModule;

    @OneToOne
    private AssignmentAnswer assignmentAnswer;
}
