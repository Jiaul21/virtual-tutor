package com.jiaul.virtualtutor.scheduler;


import com.jiaul.virtualtutor.email.EmailService;
import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import com.jiaul.virtualtutor.entities.task.Task;
import com.jiaul.virtualtutor.entities.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ScheduledService {

    @Autowired
    private EmailService emailService;

    public boolean isEmailSent(Task task) {
        AtomicInteger count = new AtomicInteger();

        CourseModule courseModule = new CourseModule();
        courseModule = task.getCourseModule();
        Course course = new Course();
        course = courseModule.getCourse();
        Teacher teacher = new Teacher();
        teacher = course.getCourseTeacher();

        String courseTitle = course.getTitle();
        String moduleName = courseModule.getName();
        String moduleTopic = courseModule.getTopics();
        String courseTeacher = teacher.getFirstName();

        course.getCourseStudents().forEach(student -> {
            if (emailService.emailForAddModule(
                    student.getUserCredential().getEmail(),
                    student.getFirstName(), courseTitle,
                    moduleName, moduleTopic, courseTeacher).equals("SUCCESS")) {
                count.addAndGet(1);
            }
        });
        System.out.println("Total Student: " + course.getCourseStudents().size() +
                "Email sent successfully: " + count);

        return true;
    }
}
