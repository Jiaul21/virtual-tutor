package com.jiaul.virtualtutor.entities.module;


import com.jiaul.virtualtutor.entities.course.CourseService;
import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseModuleService {

    @Autowired
    private CourseModuleRepository courseModuleRepository;
    @Autowired
    private CourseService courseService;
//    @Autowired
//    private ContentService contentService;

    public CourseModule addCourseModule(CourseModule courseModule) {
        return courseModuleRepository.save(courseModule);
    }

    public CourseModule getCourseModuleById(int id) {
        return courseModuleRepository.findById(id).orElseThrow();
    }

    public String deleteCourseModuleById(int id){
         courseModuleRepository.deleteById(id);
         return "Deleted courseModuleId: "+id;
    }
}
