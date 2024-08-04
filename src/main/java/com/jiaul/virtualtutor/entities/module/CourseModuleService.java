package com.jiaul.virtualtutor.entities.module;


import com.jiaul.virtualtutor.entities.course.Course;
import com.jiaul.virtualtutor.entities.course.CourseService;
import com.jiaul.virtualtutor.entities.module.dto.CourseModuleRequest;
import com.jiaul.virtualtutor.entities.module.dto.CourseModuleResponse;
import com.jiaul.virtualtutor.entities.task.Task;
import com.jiaul.virtualtutor.entities.task.TaskService;
import com.jiaul.virtualtutor.enums.CourseContent;
import com.jiaul.virtualtutor.enums.TaskType;
import com.jiaul.virtualtutor.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseModuleService {

    @Autowired
    private CourseModuleRepository courseModuleRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private Scheduler scheduler;


    public CourseModule addCourseModule(CourseModuleRequest courseModuleRequest) throws IOException {
        CourseModule courseModule = new CourseModule();
        courseModule.setName(courseModuleRequest.getName());
        courseModule.setTopics(courseModuleRequest.getTopics());
        courseModule.setThumbnail(courseModuleRequest.getThumbnail());
        courseModule.setContentName(courseModuleRequest.getContentName());

        String fileType = courseModule.getContentName().substring(courseModule.getContentName().lastIndexOf('.'));
        if (fileType.equals(".mp4") || fileType.equals(".mkv"))
            courseModule.setContentType(CourseContent.VIDEO.toString());
        else if (fileType.equals(".pdf")) courseModule.setContentType(CourseContent.PDF.toString());
        else if (fileType.equals(".ppt")) courseModule.setContentType(CourseContent.PPT.toString());
        else if (fileType.equals(".docx")) courseModule.setContentType(CourseContent.DOC.toString());

        courseModule.setContentSource(courseModuleRequest.getContentSource());
        courseModule.setPublishingDateTime(courseModuleRequest.getPublishingDateTime());
        courseModule.setActive(true);

        Course course = courseService.getCourseByID(courseModuleRequest.getCourse().getId());
        if (course.getCourseModules().isEmpty()) course.setActive(true);
        course = courseService.updateCourse(course);

        courseModule.setCourse(course);
        courseModule = courseModuleRepository.save(courseModule);

        Task task = new Task();
        task.setTaskType(TaskType.ADD_MODULE_NOTIFY.toString());
        task.setDone(false);
        task.setDateTime(courseModule.getPublishingDateTime());
        task.setCourseModule(courseModule);
        taskService.createTask(task);
        scheduler.setChanged(true);

        return courseModule;
    }

    public CourseModule getCourseModuleById(int id) {
        return courseModuleRepository.findById(id).orElseThrow();
    }

    public List<CourseModuleResponse> getAllModuleByCourseId(int id) {
        System.out.println("course id: " + id);

        Course course = new Course();
        course.setId(id);
        List<CourseModuleResponse> courseModuleResponses = new ArrayList<>();
        courseModuleRepository.findAllByCourse(course).forEach(module -> {
            if (module.isActive() && module.getPublishingDateTime().before(new Date())) {
                CourseModuleResponse moduleResponse = new CourseModuleResponse();
                moduleResponse.setId(module.getId());
                moduleResponse.setName(module.getName());
                moduleResponse.setThumbnail(module.getThumbnail());
                moduleResponse.setContentType(moduleResponse.getContentType());
                moduleResponse.setContentName(module.getContentName());
                moduleResponse.setContentSource(module.getContentSource());
                moduleResponse.setPublishingDateTime(module.getPublishingDateTime());
                moduleResponse.setActive(module.isActive());
                moduleResponse.setCourseTitle(module.getCourse().getTitle());
                moduleResponse.setCourseTeacher(module.getCourse().getCourseTeacher().getFirstName());

                courseModuleResponses.add(moduleResponse);
            }
        });
        return courseModuleResponses;
    }

    public String deleteCourseModuleById(int id) {
        courseModuleRepository.deleteById(id);
        return "Deleted courseModuleId: " + id;
    }

    public int countTotalModules() {
        return (int) courseModuleRepository.count();
    }
}
