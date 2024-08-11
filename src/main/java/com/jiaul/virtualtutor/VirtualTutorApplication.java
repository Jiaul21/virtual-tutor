package com.jiaul.virtualtutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class VirtualTutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirtualTutorApplication.class, args);
        System.out.println("Vitual Tutor started");

    }
}
