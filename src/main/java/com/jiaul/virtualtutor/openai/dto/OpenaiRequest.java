package com.jiaul.virtualtutor.openai.dto;

import com.jiaul.virtualtutor.openai.Message;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OpenaiRequest {
    private String model;
    private List<Message> messages;

    public OpenaiRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }
}
