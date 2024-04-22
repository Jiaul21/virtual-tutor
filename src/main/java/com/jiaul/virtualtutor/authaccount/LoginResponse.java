package com.jiaul.virtualtutor.authaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiaul.virtualtutor.response.AuthResponse;
import com.jiaul.virtualtutor.response.HttpResponse;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {

    private String name;
    private String email;
    private String role;
    private AuthResponse authResponse;
    private HttpResponse httpResponse;
}
