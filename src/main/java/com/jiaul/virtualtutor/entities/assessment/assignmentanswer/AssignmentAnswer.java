package com.jiaul.virtualtutor.entities.assessment.assignmentanswer;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.assessment.assignment.Assignment;
import com.jiaul.virtualtutor.entities.student.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AssignmentAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private float obtainedMark;
    private String answerType;
    private Date submissionTime;
    private String answerSource;

    @OneToOne
    private Assignment assignment;

    @OneToOne
    private Student student;
}
