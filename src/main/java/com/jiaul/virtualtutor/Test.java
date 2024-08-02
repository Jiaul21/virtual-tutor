package com.jiaul.virtualtutor;

import com.jiaul.virtualtutor.email.EmailService;
import com.jiaul.virtualtutor.entities.dashbord.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Base64;


//@Configuration
@RestController
public class Test {
//    public static void main(String[] args) {


        @Autowired
        EmailService emailService;

        @GetMapping("/email")
        public void sentMail(){
            String status=emailService.emailForAddModule("riyad.temp@gmail.com",
                    "Jiaul Haque",
                    "Advanced Java Enterprise",
                    "Module 5",
                    "SMTP server",
                    "Abir");

            System.out.println(status);
        }

//    }
}
