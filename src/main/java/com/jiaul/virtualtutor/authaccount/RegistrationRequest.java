package com.jiaul.virtualtutor.authaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationRequest {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{4,}$") //Minimum 4 characters, at least one letter and one number
    private String password;
    @NotNull
    @NotBlank
    private String role;
}
