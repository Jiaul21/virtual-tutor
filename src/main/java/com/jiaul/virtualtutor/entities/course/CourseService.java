package com.jiaul.virtualtutor.entities.course;


import com.jiaul.virtualtutor.entities.course.dto.CourseRequest;
import com.jiaul.virtualtutor.entities.module.CourseModule;
import com.jiaul.virtualtutor.entities.module.CourseModuleService;
import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import com.jiaul.virtualtutor.fileserver.FileManagementService;
import com.jiaul.virtualtutor.fileserver.FileService;
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
    private FileManagementService fileManagementService;

    /*
    creating course with list of courseModule
     */
    public Course createCourse(CourseRequest courseRequest) throws IOException {
        Course course=new Course();
        course.setTitle(courseRequest.getTitle());
//        course.setImage(fileManagementService.storeCourseImage(courseRequest.getImage()));
        course.setType(courseRequest.getType().toString());
        course.setCategory(courseRequest.getCategory().toString());
        course.setDescription(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
        course.setPrice(courseRequest.getPrice());
        course.setOffer(courseRequest.getOffer());
        course.setPublishingDateTime(courseRequest.getPublishingDateTime());
        if(course.getPublishingDateTime().before(new Date())){ course.setActive(true);}

        List<CourseModule> courseModules = new ArrayList<>();
        for (CourseModuleRequest courseModuleRequest : courseRequest.getCourseModuleRequests()) {
            CourseModule courseModule = new CourseModule();
            courseModule.setName(courseModuleRequest.getName());
            courseModule.setTopics(courseModuleRequest.getTopics());
            courseModule.setThumbnail(fileManagementService.storeModuleThumbnail(courseModuleRequest.getThumbnail()));
            courseModule.setContentType(courseModuleRequest.getContentType());
            courseModule.setContentName(courseModuleRequest.getContentName());
            courseModule.setContentSource(fileManagementService.storeCourseVideo(courseModuleRequest.getContentSource()));
            courseModule.setPublishingDateTime(courseModuleRequest.getPublishingDateTime());
            if(courseModule.getPublishingDateTime().before(new Date())){ courseModule.setActive(true);}
            courseModule.setCourse(course);

            courseModules.add(courseModule);
        }
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
