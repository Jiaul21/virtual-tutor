package com.jiaul.virtualtutor.entities.common;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
    private String bio;

}
