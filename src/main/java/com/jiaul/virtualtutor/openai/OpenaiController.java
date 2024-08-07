package com.jiaul.virtualtutor.openai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/openai")
public class OpenaiController {

    @Autowired
    private OpenaiService openaiService;

    @PostMapping("/question")
    public String getAns(){
        String prompt="Call api";
        System.out.println(prompt);
        return openaiService.getChat(prompt);
    }
}
