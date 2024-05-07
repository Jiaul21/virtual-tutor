package com.jiaul.virtualtutor.entities.content.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContentRequest {

    private int id;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String source;
    @NotBlank
    @NotNull
    private String type;    // video or document
}
