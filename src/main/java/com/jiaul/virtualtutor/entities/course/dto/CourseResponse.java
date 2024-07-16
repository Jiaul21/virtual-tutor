package com.jiaul.virtualtutor.entities.course.dto;

import com.jiaul.virtualtutor.entities.module.CourseModule;
import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import com.jiaul.virtualtutor.entities.student.Student;
import com.jiaul.virtualtutor.entities.teacher.Teacher;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CourseResponse {
    private int id;
    private String title;
    private String image;
    private String type;        // ongoing or ready
    private String category;    // academic or skills
    private String duration;    // 8 weeks or 10 hours
    private String description;
    private float rating;
    private float price;
    private float offer;
    private Date publishingDateTime;
    private boolean isActive;

    private List<CourseModule> courseModules;
    private List<Student> courseStudents;
    private int courseTeacher;
}
