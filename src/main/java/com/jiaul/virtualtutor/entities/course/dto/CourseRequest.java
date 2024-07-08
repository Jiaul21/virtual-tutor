package com.jiaul.virtualtutor.entities.course.dto;

import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import com.jiaul.virtualtutor.entities.teacher.Teacher;
import com.jiaul.virtualtutor.enums.CourseCategory;
import com.jiaul.virtualtutor.enums.CourseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class CourseRequest {

    private int id;
    @NotNull
    @NotBlank
    private String title;
    private MultipartFile image;
    private CourseType type;        // ongoing or ready
    private CourseCategory category;    // academic or skills
    private String duration;    // 8 weeks or 10 hours
    private String description;
    private float price;
    private float offer;
    private Date publishingDateTime;

    private Teacher courseTeacher;

    private List<CourseModuleRequest> courseModuleRequests;
}
