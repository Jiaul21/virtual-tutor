package com.jiaul.virtualtutor.entities.common;


import com.jiaul.virtualtutor.entities.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Data
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institute;
    private String program;
    private Year passingYear;
    @ManyToOne
    private Teacher teacher;
}
