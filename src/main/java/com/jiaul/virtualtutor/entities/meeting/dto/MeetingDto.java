package com.jiaul.virtualtutor.entities.meeting.dto;

import com.jiaul.virtualtutor.entities.course.Course;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
public class MeetingDto {

    private int id;
    private String title;
    private String meetingId;
    private String meetingLink;
    private Date meetingTime;

    private int course;
}
