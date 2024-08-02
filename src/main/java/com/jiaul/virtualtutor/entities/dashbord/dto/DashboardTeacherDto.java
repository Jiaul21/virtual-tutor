package com.jiaul.virtualtutor.entities.dashbord.dto;

import lombok.Data;

@Data
public class DashboardTeacherDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String photo;
    private String gender;
    private String language;
    private String country;
    private String city;
    private boolean isActive;

    private int totalSell;
    private int totalCourse;
    private int userCredential;
}
