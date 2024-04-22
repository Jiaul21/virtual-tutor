package com.jiaul.virtualtutor;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Test {

    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{4,}$") //Minimum 4 characters, at least one letter and one number
    private String password;

}
