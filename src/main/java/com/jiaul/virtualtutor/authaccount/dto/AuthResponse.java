package com.jiaul.virtualtutor.authaccount.dto;

import lombok.Data;

@Data
public class AuthResponse {

    private int id;
    private String name;
    private String email;
    private String role;
    private byte[] photo;
    private String message;
    private String jwtToken;
    private String jwtTokenType;
}
