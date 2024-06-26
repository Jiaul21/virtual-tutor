package com.jiaul.virtualtutor.entities.assessment.mcqtest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class McqQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mcqNo;
    private String mcqQuestion;
    private int mcqMark;
    private String image;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
    private String option_E;
    private String option_F;
    private String option_G;
    private char mcqAnswer;

    @ManyToOne
    private McqTest mcqTest;
}
