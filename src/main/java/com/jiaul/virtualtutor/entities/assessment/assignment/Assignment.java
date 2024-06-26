package com.jiaul.virtualtutor.entities.assessment.assignment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.assessment.assignmentanswer.AssignmentAnswer;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int assignmentNo;
    private int totalMarks;
    private Date submissionStart;
    private Date submissionEnd;
    private boolean isActive;
    private String questionType;
    private String assignmentSource;

    @ManyToOne
    private CourseModule courseModule;

    @OneToOne
    private AssignmentAnswer assignmentAnswer;
}
