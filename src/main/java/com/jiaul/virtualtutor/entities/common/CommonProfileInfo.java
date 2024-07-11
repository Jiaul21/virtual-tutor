package com.jiaul.virtualtutor.entities.common;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class CommonProfileInfo {

    private String firstName;
    private String lastName;
    private byte[] photo;
    private String phone;
    private String gender;
    private String language;
    private String country;
    private String city;
}
