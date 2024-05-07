package com.jiaul.virtualtutor.entities.userprofile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileResponse {

    private int id;
    private String name;
    private String photo;
}
