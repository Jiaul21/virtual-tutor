package com.jiaul.virtualtutor.entities.course;


import com.jiaul.virtualtutor.entities.course.dto.CourseRequest;
import com.jiaul.virtualtutor.entities.course.dto.CourseResponse;
import com.jiaul.virtualtutor.entities.student.Student;
import com.jiaul.virtualtutor.entities.student.StudentRepository;
import com.jiaul.virtualtutor.entities.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    /*
    creating course with list of courseModule
     */
    public Course createCourse(CourseRequest courseRequest) throws IOException {
        Course course = new Course();
        course.setTitle(courseRequest.getTitle());
        course.setImage(courseRequest.getImage());
        course.setType(courseRequest.getType());
        course.setCategory(courseRequest.getCategory());
        course.setDescription(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
        course.setPrice(courseRequest.getPrice());
        course.setOffer(courseRequest.getOffer());
        course.setPublishingDateTime(courseRequest.getPublishingDateTime());
        course.setActive(false);
        course.setCourseTeacher(courseRequest.getCourseTeacher());

        return courseRepository.save(course);
    }

    public Course buyCourse(int courseId, int studentId) {
        Course course = getCourseByID(courseId);

        Student student=studentRepository.findById(studentId).orElseThrow();
        List<Course> courses=new ArrayList<>();
        courses=student.getBuyCourses();
        courses.add(course);
        student.setBuyCourses(courses);
        student=studentRepository.save(student);
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

    public List<Course> getAllCourse(){ return courseRepository.findAll(); }

    public int countTotalCoursesByCategory(String category){
        return (int) courseRepository.countByCategory(category);
    }

    public List<CourseResponse> getCourseByCategory(String category) {
        System.out.println("category: " + category);

        List<CourseResponse> courseResponses = new ArrayList<>();
        courseRepository.findByCategory(category).forEach(course -> {
            if (course.isActive() && course.getPublishingDateTime().before(new Date())) {
                CourseResponse courseResponse = new CourseResponse();
                courseResponse.setId(course.getId());
                courseResponse.setTitle(course.getTitle());
                courseResponse.setImage(course.getImage());
                courseResponse.setType(course.getType());
                courseResponse.setCategory(course.getCategory());
                courseResponse.setDuration(course.getDuration());
                courseResponse.setDescription(course.getDescription());
                courseResponse.setRating(course.getRating());
                courseResponse.setPrice(course.getPrice());
                courseResponse.setOffer(course.getOffer());
                courseResponse.setPublishingDateTime(course.getPublishingDateTime());
                courseResponse.setActive(course.isActive());

                List<Student> students = new ArrayList<>();
                course.getCourseStudents().forEach(student -> {
                    Student student1 = new Student();
                    student1.setId(student.getId());
                    students.add(student1);
                });
                courseResponse.setCourseStudents(students);
                courseResponse.setCourseTeacher(course.getCourseTeacher().getId());

                courseResponses.add(courseResponse);
            }
        });
        return courseResponses;
    }


}
