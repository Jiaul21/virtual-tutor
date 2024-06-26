package com.jiaul.virtualtutor.entities.assessment.mcqresult;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.assessment.mcqtest.McqTest;
import com.jiaul.virtualtutor.entities.student.Student;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class McqResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int obtainedMark;

    @OneToOne
    private McqTest mcqTest;

    @OneToOne
    private Student student;
}
