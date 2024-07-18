package com.jiaul.virtualtutor.entities.module.dto;

import com.jiaul.virtualtutor.entities.course.Course;
import lombok.Data;

import java.util.Date;

@Data
public class CourseModuleResponse {
    private int id;
    private String name;
    private String topics;  // specific topic
    private String thumbnail;
    private String contentType; // video or pdf
    private String contentName;
    private String contentSource;
    private Date publishingDateTime;
    private boolean isActive;

    private int course;

}
