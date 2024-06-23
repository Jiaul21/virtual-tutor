package com.jiaul.virtualtutor.entities.module.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CourseModuleRequest {

    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String topic;      // specific topic
    private String thumbnail;
    private String duration;    // 8 weeks or 10 hours
    private Date publishingDate;
    private Date publishingTime;
    @NotNull
    @NotBlank
    private String contentType; // video or pdf

    @NotNull
    @NotBlank
    private  int courseId;
}
