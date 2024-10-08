package com.jiaul.virtualtutor.entities.dashbord;

import com.jiaul.virtualtutor.entities.course.CourseService;
import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardCourseDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardStudentDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardTeacherDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.TotalCount;
import com.jiaul.virtualtutor.entities.discussion.DiscussionService;
import com.jiaul.virtualtutor.entities.module.CourseModuleService;
import com.jiaul.virtualtutor.entities.student.StudentService;
import com.jiaul.virtualtutor.entities.teacher.TeacherService;
import com.jiaul.virtualtutor.enums.CourseCategory;
import com.jiaul.virtualtutor.fileserver.FileService;
import com.jiaul.virtualtutor.user.UserCredential;
import com.jiaul.virtualtutor.user.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseModuleService moduleService;
    @Autowired
    private DiscussionService discussionService;
    @Autowired
    private FileService fileService;
    @Autowired
    private UserCredentialService userCredentialService;


    public List<DashboardTeacherDto> getTeachersInfo() {
        List<DashboardTeacherDto> dashboardTeacherDtosList = new ArrayList<>();

        teacherService.getAllTeacher().forEach(teacher -> {
            DashboardTeacherDto teacherDto = new DashboardTeacherDto();
            teacherDto.setId(teacher.getId());
            teacherDto.setFirstName(teacher.getFirstName());
            teacherDto.setLastName(teacherDto.getLastName());
            teacherDto.setEmail(teacher.getUserCredential().getEmail());
            teacherDto.setPhoto(fileService.getBase64(teacher.getPhoto()));
            teacherDto.setLanguage(teacher.getLanguage());
            teacherDto.setCountry(teacher.getCountry());
            teacherDto.setCity(teacher.getCity());
            teacherDto.setActive(teacher.isActive());
            teacherDto.setTotalCourse(teacher.getSellCourses().size());
            teacherDto.setTotalSell(teacher.getTotalSell());
            teacherDto.setUserCredential(teacher.getUserCredential().getId());

            dashboardTeacherDtosList.add(teacherDto);
        });
        return dashboardTeacherDtosList;
    }

    public List<DashboardStudentDto> getStudentsInfo() {
        List<DashboardStudentDto> dashboardStudentDtoList = new ArrayList<>();

        studentService.getAllStudent().forEach(student -> {
            DashboardStudentDto studentDto = new DashboardStudentDto();
            studentDto.setId(student.getId());
            studentDto.setFirstName(student.getFirstName());
            studentDto.setLastName(student.getLastName());
            studentDto.setEmail(student.getUserCredential().getEmail());
            studentDto.setPhoto(fileService.getBase64(student.getPhoto()));
            studentDto.setLanguage(student.getLanguage());
            studentDto.setCountry(student.getCountry());
            studentDto.setCity(student.getCity());
            studentDto.setActive(student.isActive());
            studentDto.setTotalEnrolledCourse(student.getBuyCourses().size());
            studentDto.setUserCredential(student.getUserCredential().getId());

            dashboardStudentDtoList.add(studentDto);
        });
        return dashboardStudentDtoList;
    }

    public List<DashboardCourseDto> getCoursesInfo() {
        List<DashboardCourseDto> dashboardCourseDtoList = new ArrayList<>();

        courseService.getAllCourse().forEach(course -> {
            DashboardCourseDto courseDto = new DashboardCourseDto();
            courseDto.setId(course.getId());
            courseDto.setTitle(course.getTitle());
            courseDto.setImage(course.getImage());
            courseDto.setType(course.getType());
            courseDto.setCategory(course.getCategory());
            courseDto.setDuration(course.getDuration());
            courseDto.setRating(course.getRating());
            courseDto.setPrice(course.getPrice());
            courseDto.setOffer(course.getOffer());
            courseDto.setPublishingDateTime(course.getPublishingDateTime());
            courseDto.setActive(course.isActive());
            courseDto.setTotalStudents(course.getCourseStudents().size());

            dashboardCourseDtoList.add(courseDto);
        });
        return dashboardCourseDtoList;
    }

    public TotalCount getTotaLCount() {
        TotalCount totalCount = new TotalCount();
        totalCount.setTotalStudents(displayCount(studentService.countTotalStudents()));
        totalCount.setTotalTeachers(displayCount(teacherService.countTotalTeachers()));
        totalCount.setTotalModules(displayCount(moduleService.countTotalModules()));
        totalCount.setTotalAcademicCourses(displayCount(courseService.countTotalCoursesByCategory(CourseCategory.ACADEMIC.toString())));
        totalCount.setTotalSkillCourses(displayCount(courseService.countTotalCoursesByCategory(CourseCategory.SKILL.toString())));
        totalCount.setTotalDiscussions(displayCount(discussionService.countTotalDiscussion()));

        return totalCount;
    }

    public String displayCount(int count) {
        if (count >= 1000) {
            if (count % 100 != 0) return String.valueOf((count / 100) * 100) + " +";
            else return String.valueOf(count);
        } else if (count >= 10) {
            if (count % 10 != 0) return String.valueOf((count / 10) * 10) + " +";
            else return String.valueOf(count);
        }
        return String.valueOf(count);
    }

    public String updateUserCredentialActiveStatus(String email,boolean enabled){
        return userCredentialService.updateActiveStatus(email,enabled);
    }

}
