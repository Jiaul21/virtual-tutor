package com.jiaul.virtualtutor.entities.assessment.mcqtest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.assessment.mcqresult.McqResult;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class McqTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int totalMarks;
    private Date submissionStart;
    private Date submissionEnd;
    private boolean isActive;

    @OneToOne
    private CourseModule courseModule;

    @OneToMany(mappedBy = "mcqTest", cascade = CascadeType.ALL)
    private List<McqQuestion> mcqQuestions;

    @OneToOne
    private McqResult mcqResult;
}
