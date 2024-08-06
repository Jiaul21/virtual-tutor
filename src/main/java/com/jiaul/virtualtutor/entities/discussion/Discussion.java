package com.jiaul.virtualtutor.entities.discussion;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaul.virtualtutor.entities.student.Student;
import com.jiaul.virtualtutor.entities.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    private String image;
    private Date dateTime;
    private int vote;

//    private int parentMessageId;        // parentMessageId 0 for root message
    private int courseModuleId;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Student student;

    @ManyToOne
    private  Discussion parentMessage;

    @OneToMany(mappedBy = "parentMessage",cascade = CascadeType.ALL)
    private List<Discussion> replies;
}
