package com.jiaul.virtualtutor.entities.module.dto;

import com.jiaul.virtualtutor.entities.assessment.assignment.Assignment;
import com.jiaul.virtualtutor.entities.assessment.mcqtest.McqTest;
import com.jiaul.virtualtutor.entities.course.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class CourseModuleRequest {

    private int id;
    @NotNull
    @NotBlank
    private String name;
    private String topics;  // specific topic
    private String thumbnail;
    private String contentType; // video or pdf
    private String contentName;
    private String contentSource;
    private Date publishingDateTime;
    @NotNull
    @NotBlank
    private Course course;
}
