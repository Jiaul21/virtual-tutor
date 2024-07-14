package com.jiaul.virtualtutor.entities.common;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@MappedSuperclass
public class CommonProfileInfo {

    private String firstName;
    private String lastName;
    @Column(columnDefinition="TEXT")
    @Lob
    private String photo;
    private String phone;
    private String gender;
    private String language;
    private String country;
    private String city;
    private String bio;

}
