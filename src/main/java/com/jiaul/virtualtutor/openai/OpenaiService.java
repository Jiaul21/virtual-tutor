package com.jiaul.virtualtutor.openai;

import com.jiaul.virtualtutor.openai.dto.OpenaiRequest;
import com.jiaul.virtualtutor.openai.dto.OpenaiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenaiService {

    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String openaiApiUrl;


    @Autowired
    private RestTemplate restTemplate;

    public String getChat(String prompt) {
        OpenaiRequest openaiRequest = new OpenaiRequest(model, prompt);
        OpenaiResponse openaiResponse = restTemplate.postForObject(openaiApiUrl,openaiRequest, OpenaiResponse.class);
        return openaiResponse.getChoices().get(0).getMessage().getContent();
    }
}
