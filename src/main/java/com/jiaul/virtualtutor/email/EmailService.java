package com.jiaul.virtualtutor.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmailService {

    @Autowired
    private EmailSender emailSender;

    public String emailForAddModule(String toEmail,String studentName,
                                 String courseTitle,String moduleName,String moduleTopic,String courseTeacher) {
        String subject="Exciting New Module Added to " +courseTitle+"!";
        String addModuleEmailContent = "<html>"
                + "<body>"
                + "Dear " + studentName + ",<br><br>"
                + "We are excited to inform you that a brand-new module has been added to your <b>" + courseTitle + "</b> course! "
                + "The new module, titled <b>" + moduleName + "</b>, will dive into the fascinating topic of <b>" + moduleTopic + "</b> and is now live on your course platform.<br><br>"
                + "<b>What’s New:</b><br>"
                + "- <b>Module Name:</b> " + moduleName + "<br>"
                + "- <b>Topic:</b> " + moduleTopic + "<br>"
                + "- Engaging content with real-world applications<br>"
                + "- Interactive lessons and resources<br><br>"
                + "<b>Course Information:</b><br>"
                + "<b>Course Name:</b> " + courseTitle + "<br>"
                + "<b>Instructor:</b> " + courseTeacher + "<br><br>"
                + "To access the new module, log in to your course account and visit the modules section. "
                + "We highly recommend starting this module soon to stay on track and maximize your learning experience.<br><br>"
                + "If you have any questions or need assistance, do not hesitate to contact " + courseTeacher + " or our support team.<br><br>"
                + "Wishing you continued success in your studies!<br><br>"
                + "Best regards,<br>"
                + "Management Team<br>"
                + "Virtual-Tutor<br>"
                + "</body>"
                + "</html>";
        if(emailSender.sendEmail(toEmail,subject,addModuleEmailContent)){
            return "SUCCESS";
        }
        return "FAILED";
    }

    public String emailForCourseMeeting(String toEmail, String studentName,
                                        String courseTitle, Date meetingTime, String courseTeacher) {
        String subject="Meeting Schedule for " +courseTitle+"!";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        String formattedMeetingTime = dateFormat.format(meetingTime);

        String meetingScheduleContent = "<html>"
                + "<body>"
                + "Dear " + studentName + ",<br><br>"
                + "We are pleased to inform you about the upcoming meeting for your course, <b>" + courseTitle + "</b>.<br><br>"
                + "<b>Meeting Details:</b><br>"
                + "Date and Time: " + formattedMeetingTime + "<br>"
                + "Instructor: " + courseTeacher + "<br><br>"
                + "We look forward to your participation.<br><br>"
                + "Best regards,<br>"
                + courseTeacher + "<br>"
                + "Course Instructor"
                + "</body>"
                + "</html>";

        if(emailSender.sendEmail(toEmail,subject,meetingScheduleContent)){
            return "SUCCESS";
        }
        return "FAILED";
    }


}
