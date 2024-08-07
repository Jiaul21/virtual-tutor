package com.jiaul.virtualtutor.entities.discussion.dto;

import com.jiaul.virtualtutor.entities.discussion.Discussion;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DiscussionDto {
    private int id;
    private String message;
    private String image;
    private Date dateTime;
    private int vote;

    private int parentMessageId;        // parentMessageId 0 for root message
    private int courseModuleId;

    private int senderId;
    private String senderName;
    private String senderRole;
    private String senderPhoto;

    private List<DiscussionDto> replies;
}
