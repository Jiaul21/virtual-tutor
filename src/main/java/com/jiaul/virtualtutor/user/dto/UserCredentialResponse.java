package com.jiaul.virtualtutor.user.dto;

import lombok.Data;

@Data
public class UserCredentialResponse {
    private int id;
    private String name;
    private String email;
    private String role;
}
