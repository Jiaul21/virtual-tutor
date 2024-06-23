package com.jiaul.virtualtutor.entities.common;

import com.jiaul.virtualtutor.entities.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String job;
    private String designation;
    private Date startFrom;
    private Date endTo;
    @ManyToOne
    private Teacher teacher;
}
