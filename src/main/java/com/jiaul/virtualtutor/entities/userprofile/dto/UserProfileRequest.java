package com.jiaul.virtualtutor.entities.userprofile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserProfileRequest {
    @NotNull
    @NotBlank
    private int id;
    @NotNull
    @NotBlank
    private String email;
    private String photo;
    @NotNull
    @NotBlank
    private int ourUser;
}
