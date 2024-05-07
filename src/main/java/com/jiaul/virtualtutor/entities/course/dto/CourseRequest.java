package com.jiaul.virtualtutor.entities.course.dto;

import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseRequest {

    @NotNull
    @NotBlank
    private int id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String image;
    @NotNull
    @NotBlank
    private String type;    // ongoing or ready
    @NotNull
    @NotBlank
    private String category; //academic or skills
    private String description;
    @NotNull
    @NotBlank
    private float price;
    private float offer;
    @NotNull
    @NotBlank
    private int instructorId;

    @NotNull
    @NotBlank
    private CourseModuleRequest courseModuleRequest;
}
