package com.jiaul.virtualtutor.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse {

    private String statusCode;
    private String error;
    private String message;
}
