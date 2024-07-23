package com.jiaul.virtualtutor.entities.dashbord.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DashboardCourseDto {

    private int id;
    private String title;
    private String image;
    private String type;        // ongoing or ready
    private String category;    // academic or skills
    private String duration;    // 8 weeks or 10 hours
    private float rating;
    private float price;
    private float offer;
    private Date publishingDateTime;
    private boolean isActive;
    private int totalStudents;
}
