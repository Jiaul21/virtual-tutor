package com.jiaul.virtualtutor.course;

import com.jiaul.virtualtutor.content.Content;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//@Entity
//@Data
public class Course {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String topic;
    private String type; //academic or skills
    private String description;
    private String mentor;
    private float price;
    private int offer;
    private String contentType;
    private Content content;


}
