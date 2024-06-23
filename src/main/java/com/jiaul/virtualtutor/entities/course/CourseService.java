package com.jiaul.virtualtutor.entities.course;


import com.jiaul.virtualtutor.entities.module.CourseModule;
import com.jiaul.virtualtutor.entities.module.CourseModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseModuleService courseModuleService;

    public Course createCourse(Course course) {
        List<CourseModule> courseModules = course.getCourseModules();
        courseModules.forEach(courseModule -> {
            courseModule.setCourse(course);
        });
        course.setCourseModules(courseModules);
        return courseRepository.save(course);
    }

    public Course buyCourse(int courseId, int studentId) {
        Course course = getCourseByID(courseId);
//        UserProfile student = userProfileService.getUserProfileById(studentId);
//        List<Course> buyCourses = student.getBuyCourses();
////        List<UserProfile> students = course.getStudents();
//        buyCourses.add(course);
////        students.add(student);
//        course = updateCourse(course);
//        student = userProfileService.updateUserProfile(student);
        return course;
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseByID(int courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }

    public List<Course> getCourseByType(String type) {
        return courseRepository.findByType(type);
    }

    public List<Course> getCourseByCategory(String category) {
        return courseRepository.findByCategory(category);
    }

//    public List<Course> getCourseByInstructor(UserProfile instructor) {
//        return courseRepository.findByInstructor(instructor);
//    }


}
