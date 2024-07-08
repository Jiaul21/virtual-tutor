package com.jiaul.virtualtutor.entities.module;


import com.jiaul.virtualtutor.entities.course.CourseService;
import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import com.jiaul.virtualtutor.fileserver.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class CourseModuleService {

    @Autowired
    private CourseModuleRepository courseModuleRepository;

    @Autowired
    private FileManagementService fileManagementService;

    public CourseModule addCourseModule(CourseModuleRequest courseModuleRequest) throws IOException {
        CourseModule courseModule = new CourseModule();
        courseModule.setName(courseModuleRequest.getName());
        courseModule.setTopics(courseModuleRequest.getTopics());
        courseModule.setThumbnail(fileManagementService.storeModuleThumbnail(courseModuleRequest.getThumbnail()));
        courseModule.setContentType(courseModuleRequest.getContentType());
        courseModule.setContentName(courseModuleRequest.getContentName());
        courseModule.setContentSource(fileManagementService.storeCourseVideo(courseModuleRequest.getContentSource()));
        courseModule.setPublishingDateTime(courseModuleRequest.getPublishingDateTime());
        if(courseModule.getPublishingDateTime().before(new Date())){ courseModule.setActive(true);}
        courseModule.setCourse(courseModuleRequest.getCourse());
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
